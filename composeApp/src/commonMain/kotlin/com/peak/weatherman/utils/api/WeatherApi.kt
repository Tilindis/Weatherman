package com.peak.weatherman.utils.api

import com.peak.weatherman.utils.response.WeatherResponse

interface WeatherApi {
    suspend fun requestWeather(): WeatherResponse
}
