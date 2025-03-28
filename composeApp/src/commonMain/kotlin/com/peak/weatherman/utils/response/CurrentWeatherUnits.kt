package com.peak.weatherman.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherUnits(
    val time: String? = null,
    val interval: String? = null,
    val temperature: String? = null,
    val windspeed: String? = null,
    val winddirection: String? = null,
    val is_day: String? = null,
    val weathercode: String? = null,
)
