package com.peak.weatherman.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class HourlyData(
    val time: List<String>? = null,
    val temperature_2m: List<Double>? = null,
    val winddirection_10m: List<Int>? = null,
)
