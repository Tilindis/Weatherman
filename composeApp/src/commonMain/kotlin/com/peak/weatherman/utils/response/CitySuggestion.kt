package com.peak.weatherman.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class CitySuggestion(
    val name: String? = null,
    val country: String? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    val fullName: String? = null,
)
