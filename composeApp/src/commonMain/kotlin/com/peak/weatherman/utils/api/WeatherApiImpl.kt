package com.peak.weatherman.utils.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

const val ENDPOINT =
    "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&timezone=auto&current_weather=true&hourly=temperature_2m,winddirection_10m"

class WeatherApiImpl: WeatherApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    explicitNulls = false
                }
            )
        }
    }

    override suspend fun fetchWeatherList(): String {
        println("INFO: Fetching new Weather from the network...")
        return httpClient.get(urlString = ENDPOINT).body()
    }
}
