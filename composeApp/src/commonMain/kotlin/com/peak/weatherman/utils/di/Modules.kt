package com.peak.weatherman.utils.di

import com.peak.WeathermanDatabase
import com.peak.weatherman.feature.WeatherViewModel
import com.peak.weatherman.utils.api.WeatherApi
import com.peak.weatherman.utils.api.WeatherApiImpl
import com.peak.weatherman.utils.database.LocalDatabase
import com.peak.weatherman.utils.database.LocalDatabaseImpl
import com.peak.weatherman.utils.factory.DatabaseDriverFactory
import com.peak.weatherman.utils.repository.CheckRepo
import com.peak.weatherman.utils.repository.CheckRepoImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single<WeathermanDatabase> {
        get<DatabaseDriverFactory>().createWeathermanDatabase()
    }
    singleOf(::WeatherApiImpl).bind<WeatherApi>()
    singleOf(::LocalDatabaseImpl).bind<LocalDatabase>()
    singleOf(::CheckRepoImpl).bind<CheckRepo>()
    viewModelOf(::WeatherViewModel)
}
