package com.peak.weatherman.feature.main

import com.peak.weatherman.utils.entity.LocationEntity

data class MainState(
    val locations: List<LocationEntity> = emptyList(),
)
