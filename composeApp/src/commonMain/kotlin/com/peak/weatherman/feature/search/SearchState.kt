package com.peak.weatherman.feature.search

import com.peak.weatherman.utils.response.CitySuggestion

data class SearchState(
    val cities: List<CitySuggestion> = emptyList(),
    val cityName: String = "",
)
