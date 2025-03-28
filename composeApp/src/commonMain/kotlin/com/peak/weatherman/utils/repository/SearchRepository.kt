package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.response.CitySuggestion
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun searchCities(query: String, limit: Int): Flow<List<CitySuggestion>>
    fun close()
}
