package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.api.NominatimOpenstreetMapApi
import com.peak.weatherman.utils.api.WeatherApi
import com.peak.weatherman.utils.database.LocalDatabase
import com.peak.weatherman.utils.mapper.toLocationEntity
import com.peak.weatherman.utils.response.CitySuggestion
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(
    private val api: NominatimOpenstreetMapApi,
    private val weatherApi: WeatherApi,
    private val localDatabase: LocalDatabase,
) : SearchRepository {
    override suspend fun searchCities(query: String): Flow<List<CitySuggestion>> {
        return api.searchCities(query)
    }

    override suspend fun loadWeather(latitude: Double, longitude: Double) {
        weatherApi.requestWeather(
            latitude = latitude,
            longitude = longitude,
        ).collect { weatherResponse ->
            weatherResponse?.let {
                localDatabase.insertLocation(it.toLocationEntity())
            }
        }
    }

    override fun close() {
        api.close()
    }
}
