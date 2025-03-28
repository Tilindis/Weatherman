package com.peak.weatherman.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class NominatimResult(
    val display_name: String? = null,
    val lat: String? = null,
    val lon: String? = null,
    val importance: Double? = null
)
