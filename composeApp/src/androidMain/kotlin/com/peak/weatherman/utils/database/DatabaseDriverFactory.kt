package com.peak.weatherman.utils.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.peak.WeathermanDatabase
import com.peak.weatherman.utils.factory.DatabaseDriverFactory

class AndroidDatabaseDriverFactory(
    private val context: Context,
) : DatabaseDriverFactory {
    override fun createWeathermanDatabase(): WeathermanDatabase {
        return WeathermanDatabase(createDriver())
    }

    private fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = WeathermanDatabase.Schema,
            context = context,
            name = "weatherman.db"
        )
    }
}
