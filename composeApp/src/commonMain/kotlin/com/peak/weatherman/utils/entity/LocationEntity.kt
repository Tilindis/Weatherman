package com.peak.weatherman.utils.entity

data class LocationEntity(
    val timezone: String,
    val latitude: Double,
    val longitude: Double,
    val generationTimeMs: Double,
    val utcOffsetSeconds: Long,
    val timezoneAbbreviation: String,
    val elevation: Double,
)
