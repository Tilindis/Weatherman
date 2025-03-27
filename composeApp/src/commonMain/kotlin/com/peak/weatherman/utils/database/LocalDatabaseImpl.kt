package com.peak.weatherman.utils.database

import com.peak.WeathermanDatabase
import com.peak.weatherman.utils.domain.Weather

class LocalDatabaseImpl(
    private val database: WeathermanDatabase,
): LocalDatabase {
    private val query = database.weathermanDatabaseQueries

    // asFlow latter
    override fun getWeathermanData(): List<Weather> {
        println("INFO: Reading the cached data from the local database...")
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
}
