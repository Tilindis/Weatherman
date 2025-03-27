package com.peak.weatherman.utils.api

interface WeatherApi {
    suspend fun fetchWeatherList(): String
}
