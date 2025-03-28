package com.peak.weatherman.utils.api

import com.peak.weatherman.utils.response.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

const val ENDPOINT =
    "https://api.open-meteo.com/v1/forecast?latitude=42.59&longitude=-81.15&timezone=auto&current_weather=true&hourly=temperature_2m,winddirection_10m"
// 48.210033, 16.363449
// 52.52, 13.41
class WeatherApiImpl: WeatherApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
    }

    override suspend fun requestWeather(): WeatherResponse {
        println("INFO: Fetching new Weather from the network...")
        return httpClient.get(urlString = ENDPOINT).body()
    }
}
