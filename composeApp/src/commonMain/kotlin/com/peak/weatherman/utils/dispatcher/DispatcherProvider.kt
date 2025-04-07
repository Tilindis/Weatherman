package com.peak.weatherman.utils.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun getMain(): CoroutineDispatcher
    fun getIo(): CoroutineDispatcher
    fun getDefault(): CoroutineDispatcher
}
