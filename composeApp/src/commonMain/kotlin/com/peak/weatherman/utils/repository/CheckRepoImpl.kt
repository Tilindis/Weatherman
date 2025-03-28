package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.api.WeatherApi
import com.peak.weatherman.utils.database.LocalDatabase
import com.peak.weatherman.utils.domain.Weather

class CheckRepoImpl(
    private val localDatabase: LocalDatabase,
    private val weatherApi: WeatherApi,
): CheckRepo {
    override fun getText(): String {
        return "Possible to get Weather"
    }

    override fun getWeathermanData(): List<Weather> {
        return localDatabase.getWeathermanData()
    }

    override fun insertWeathermanData(data: List<Weather>) {
        localDatabase.insertWeathermanData(data)
    }

    override fun removeAllWeathermanData() {
        localDatabase.removeAllWeathermanData()
    }

    override suspend fun getWeather() {
        runCatching {
            weatherApi.requestWeather()
        }.onSuccess { weatherResponse ->
            println("INFO: API DATA -> ${weatherResponse.timezone}")
            println("INFO: API DATA -> ${weatherResponse.current_weather}")
            println("INFO: API DATA -> ${weatherResponse.current_weather_units}")
            println("INFO: API DATA -> ${weatherResponse.hourly}")
            println("INFO: API DATA -> ${weatherResponse.hourly_units}")
        }.onFailure {
            println("INFO: API DATA -> Weather API Error: ${it.message}")
        }
    }
}
