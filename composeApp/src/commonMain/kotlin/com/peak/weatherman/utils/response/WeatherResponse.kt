package com.peak.weatherman.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val latitude: Double? = null,
    val longitude: Double? = null,
    val generationtime_ms: Double? = null,
    val utc_offset_seconds: Int? = null,
    val timezone: String? = null,
    val timezone_abbreviation: String? = null,
    val elevation: Double? = null,
    val current_weather_units: CurrentWeatherUnits? = null,
    val current_weather: CurrentWeather? = null,
    val hourly_units: HourlyUnits? = null,
    val hourly: HourlyData? = null,
)
