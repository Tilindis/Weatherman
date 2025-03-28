package com.peak.weatherman.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnits(
    val time: String? = null,
    val temperature_2m: String? = null,
    val winddirection_10m: String? = null,
)
