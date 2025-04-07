package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.response.CitySuggestion
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun searchCities(query: String): Flow<List<CitySuggestion>>
    suspend fun loadWeather(latitude: Double, longitude: Double)
    fun close()
}
