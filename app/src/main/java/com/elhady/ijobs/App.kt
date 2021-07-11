package com.elhady.ijobs

import android.app.Application
import com.elhady.ijobs.di.appModule
import com.elhady.ijobs.di.persistenceModule
import com.elhady.ijobs.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by islam elhady on 22-Mar-21.
 */
class App: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(appModule)
            modules(viewModelModule)
            modules(persistenceModule)
        }
    }
}