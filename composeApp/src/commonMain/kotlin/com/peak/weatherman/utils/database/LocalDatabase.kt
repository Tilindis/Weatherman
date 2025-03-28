package com.peak.weatherman.utils.database

import com.peak.weatherman.utils.domain.Weather

interface LocalDatabase {
    fun getWeathermanData(): List<Weather>
    fun insertWeathermanData(data: List<Weather>)
    fun removeAllWeathermanData()
}
