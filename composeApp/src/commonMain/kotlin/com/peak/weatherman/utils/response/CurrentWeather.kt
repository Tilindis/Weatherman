package com.peak.weatherman.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    val time: String? = null,
    val interval: Int? = null,
    val temperature: Double? = null,
    val windspeed: Double? = null,
    val winddirection: Int? = null,
    val is_day: Int? = null,
    val weathercode: Int? = null,
)
