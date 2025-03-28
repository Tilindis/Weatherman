package com.peak.weatherman.utils.api

import com.peak.weatherman.utils.response.CitySuggestion
import kotlinx.coroutines.flow.Flow

interface NominatimOpenstreetMapApi {
    suspend fun searchCities(query: String, limit: Int): Flow<List<CitySuggestion>>
    fun close()
}
