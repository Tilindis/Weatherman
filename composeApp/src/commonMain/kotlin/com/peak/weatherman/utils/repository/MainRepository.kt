package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun loadWeather(latitude: Double, longitude: Double)
    suspend fun getLocations(): Flow<List<LocationEntity>>
}
