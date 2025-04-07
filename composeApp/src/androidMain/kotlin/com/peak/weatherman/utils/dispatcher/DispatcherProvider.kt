package com.peak.weatherman.utils.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AndroidDispatcherProvider : DispatcherProvider {
    override fun getMain(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun getIo(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    override fun getDefault(): CoroutineDispatcher {
        return Dispatchers.Default
    }
}
