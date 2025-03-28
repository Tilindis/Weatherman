package com.peak.weatherman.utils.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.peak.WeathermanDatabase
import com.peak.weatherman.utils.factory.DatabaseDriverFactory

class NativeDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createWeathermanDatabase(): WeathermanDatabase {
        return WeathermanDatabase(createDriver())
    }

    private fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = WeathermanDatabase.Schema,
            name = "weatherman.db"
        )
    }
}
