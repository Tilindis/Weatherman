package com.peak.weatherman.utils.factory

import com.peak.WeathermanDatabase

interface DatabaseDriverFactory {
    fun createWeathermanDatabase(): WeathermanDatabase
}
