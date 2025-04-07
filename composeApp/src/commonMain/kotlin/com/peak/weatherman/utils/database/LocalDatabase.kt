package com.peak.weatherman.utils.database

import com.peak.weatherman.utils.domain.Weather
import com.peak.weatherman.utils.entity.LocationEntity
import kotlinx.coroutines.flow.Flow

interface LocalDatabase {
    fun getWeathermanData(): List<Weather>
    fun insertWeathermanData(data: List<Weather>)
    fun removeAllWeathermanData()
    fun insertLocation(locationEntity: LocationEntity)
    suspend fun getLocations(): Flow<List<LocationEntity>>
}
