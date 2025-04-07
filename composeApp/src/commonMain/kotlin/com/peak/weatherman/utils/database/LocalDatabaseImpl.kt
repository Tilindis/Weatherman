package com.peak.weatherman.utils.database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.peak.WeathermanDatabase
import com.peak.weatherman.utils.dispatcher.DispatcherProvider
import com.peak.weatherman.utils.domain.Weather
import com.peak.weatherman.utils.entity.LocationEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDatabaseImpl(
    private val database: WeathermanDatabase,
    private val dispatcher: DispatcherProvider,
) : LocalDatabase {
    private val query get() = database.weathermanDatabaseQueries
    private val locationQuery get() = database.locationEntityQueries
    // private val query = database.weathermanDatabaseQueries

    // asFlow latter
    override fun getWeathermanData(): List<Weather> {
        println("INFO: Reading the cached data from the local database...")

        val smh = query.getWeathermanData().executeAsList()

        return query.getWeathermanData().executeAsList().map {
            Weather(
                cityId = it.cityId,
                time = it.time,
                interval = it.interval,
                temperature = it.temperature,
                windspeed = it.windspeed,
                winddirection = it.winddirection,
                is_day = it.is_day,
                weathercode = it.weathercode
            )
        }
    }

    override fun insertWeathermanData(data: List<Weather>) {
        println("INFO: Caching the data from the network...")
        query.transaction {
            data.forEach {
                query.insertWeathermanData(
                    cityId = it.cityId,
                    time = it.time,
                    interval = it.interval,
                    temperature = it.temperature,
                    windspeed = it.windspeed,
                    winddirection = it.winddirection,
                    is_day = it.is_day,
                    weathercode = it.weathercode,
                )
            }
        }
    }

    override fun removeAllWeathermanData() {
        query.removeAllWeathermanData()
    }

    override fun insertLocation(locationEntity: LocationEntity) {
        with(locationEntity) {
            locationQuery.insertLocation(
                timezone = timezone,
                latitude = latitude,
                longitude = longitude,
                generationTimeMs = generationTimeMs,
                utcOffsetSeconds = utcOffsetSeconds,
                timezoneAbbreviation = timezoneAbbreviation,
                elevation = elevation
            )
        }
    }

    override suspend fun getLocations(): Flow<List<LocationEntity>> {
        println("INFO: Reading the cached data from the local database...")

        return locationQuery.getLocations()
            .asFlow()
            .mapToList(dispatcher.getIo())
            .map { locations ->
                locations.map {
                LocationEntity(
                    timezone = it.timezone,
                    latitude = it.latitude,
                    longitude = it.longitude,
                    generationTimeMs = it.generationTimeMs,
                    utcOffsetSeconds = it.utcOffsetSeconds,
                    timezoneAbbreviation = it.timezoneAbbreviation,
                    elevation = it.elevation
                )
            }
        }
    }

    fun removeAllLocations() {
        locationQuery.removeAllLocations()
    }
}
