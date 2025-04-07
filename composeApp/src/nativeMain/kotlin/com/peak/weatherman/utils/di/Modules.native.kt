package com.peak.weatherman.utils.di

import com.peak.weatherman.utils.factory.DatabaseDriverFactory
import com.peak.weatherman.utils.database.NativeDatabaseDriverFactory
import com.peak.weatherman.utils.dispatcher.DispatcherProvider
import com.peak.weatherman.utils.dispatcher.NativeDispatcherProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::NativeDatabaseDriverFactory).bind<DatabaseDriverFactory>()
    singleOf(::NativeDispatcherProvider).bind<DispatcherProvider>()
}
