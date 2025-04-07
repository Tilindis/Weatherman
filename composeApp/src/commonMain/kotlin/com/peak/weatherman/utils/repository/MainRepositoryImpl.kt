package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.api.WeatherApi
import com.peak.weatherman.utils.database.LocalDatabase
import com.peak.weatherman.utils.entity.LocationEntity
import com.peak.weatherman.utils.mapper.toLocationEntity
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val weatherApi: WeatherApi,
    private val localDatabase: LocalDatabase,
): MainRepository {
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

    override suspend fun getLocations(): Flow<List<LocationEntity>> {
        return localDatabase.getLocations()
    }
}
