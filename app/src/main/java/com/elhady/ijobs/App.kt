package com.elhady.ijobs

import android.app.Application
import com.elhady.ijobs.di.*
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
            modules(networkModule)
            modules(viewModelModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(contextProviderModule)
        }
    }
}