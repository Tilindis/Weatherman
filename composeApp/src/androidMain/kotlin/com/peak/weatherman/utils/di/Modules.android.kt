package com.peak.weatherman.utils.di

import com.peak.weatherman.utils.database.AndroidDatabaseDriverFactory
import com.peak.weatherman.utils.factory.DatabaseDriverFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::AndroidDatabaseDriverFactory).bind<DatabaseDriverFactory>()
}
