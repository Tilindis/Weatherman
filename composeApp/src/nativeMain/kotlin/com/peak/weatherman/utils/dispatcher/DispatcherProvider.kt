package com.peak.weatherman.utils.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_create
import kotlin.coroutines.CoroutineContext

class NativeDispatcherProvider : DispatcherProvider {
    override fun getMain(): CoroutineDispatcher {
        return MainDispatcher
    }

    override fun getIo(): CoroutineDispatcher {
        return IODispatcher
    }

    override fun getDefault(): CoroutineDispatcher {
        return DefaultDispatcher
    }
}

// iOS Dispatchers (custom implementation)
private object MainDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) {
            block.run()
        }
    }
}

private object IODispatcher : CoroutineDispatcher() {
    private val queue = dispatch_queue_create("IODispatcher", null)
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(queue) {
            block.run()
        }
    }
}

private object DefaultDispatcher : CoroutineDispatcher() {
    private val queue = dispatch_queue_create("DefaultDispatcher", null)
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(queue) {
            block.run()
        }
    }
}
