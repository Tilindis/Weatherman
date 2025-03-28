package com.peak.weatherman.utils.domain

import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val cityId: String,
    val time: String,
    val interval: String,
    val temperature: String,
    val windspeed: String,
    val winddirection: String,
    val is_day: String,
    val weathercode: String,
)
