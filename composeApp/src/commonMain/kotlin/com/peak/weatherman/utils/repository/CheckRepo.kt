package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.domain.Weather

interface CheckRepo {
    fun getText(): String
    fun getWeathermanData(): List<Weather>
    fun insertWeathermanData(data: List<Weather>)
    fun removeAllWeathermanData()
    suspend fun getWeather()
}
