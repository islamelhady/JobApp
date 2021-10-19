package com.elhady.ijobs.utils.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class ContextProvider {
    open val Main: CoroutineContext = Dispatchers.Main
    open val IO: CoroutineContext = Dispatchers.IO

    companion object {
        @Volatile
        private var INSTANCE: ContextProvider? = null

        fun getInstance(): ContextProvider {
            return INSTANCE ?: synchronized(this) {
                ContextProvider()
            }.also {
                INSTANCE = it
            }
        }
    }
}
