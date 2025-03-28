package com.peak.weatherman.utils.api

import com.peak.weatherman.utils.response.CitySuggestion
import com.peak.weatherman.utils.response.NominatimResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class NominatimOpenstreetMapApiImpl: NominatimOpenstreetMapApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
    }

    override suspend fun searchCities(
        query: String,
        limit: Int,
    ): Flow<List<CitySuggestion>> = flow {
        runCatching {
            val results: List<NominatimResult> =
                client.get("https://nominatim.openstreetmap.org/search") {
                    parameter("q", query)
                    parameter("format", "json")
                    parameter("addressdetails", 1)
                    parameter("namedetails", 1)
                    parameter("accept-language", "en")
                    header(HttpHeaders.UserAgent, "Weatherman/1.0 (heronightmares@email.com)")
                    // header(HttpHeaders.UserAgent, "MyAppTest/0.1 (test@temp.com)")
                }.body()

            results.map { result ->
                val (cityName, country) = parseDisplayName(result.display_name)
                CitySuggestion(
                    name = cityName,
                    country = country,
                    lat = result.lat?.toDouble(),
                    lon = result.lon?.toDouble(),
                    fullName = result.display_name
                )
            }.sortedBy { it.name?.length } // Prioritize exact matches
        }.onSuccess { result ->
            emit(result)
        }.onFailure { failure ->
            println("Geocoding error: ${failure.message}")
            emit(emptyList())
        }
    }

    private fun parseDisplayName(displayName: String?): Pair<String, String> {
        val parts = displayName?.split(",")
            ?.map { it.trim() }
            ?.filter { it.isNotEmpty() }

        return when {
            parts.isNullOrEmpty() -> "Unknown" to "Unknown"
            parts.size == 1 -> parts[0] to "Unknown"
            parts.size == 2 -> parts.first() to parts.last()
            else -> {
                val locationPart = parts[parts.lastIndex - 1] + ", " + parts.last()
                parts.first() to locationPart
            }
        }
    }

    override fun close() {
        client.close()
    }
}
