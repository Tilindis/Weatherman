package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.api.NominatimOpenstreetMapApi
import com.peak.weatherman.utils.response.CitySuggestion
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(
    private val api: NominatimOpenstreetMapApi
) : SearchRepository {
    override suspend fun searchCities(query: String, limit: Int): Flow<List<CitySuggestion>> {
        return api.searchCities(query, limit)
    }

    override fun close() {
        api.close()
    }
}
