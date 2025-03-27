package com.peak.weatherman.utils.repository

import com.peak.weatherman.utils.database.LocalDatabase
import com.peak.weatherman.utils.domain.Weather

class CheckRepoImpl(
    private val localDatabase: LocalDatabase
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
        TODO("Not yet implemented")
    }
}
