package com.elhady.ijobs

import android.app.Application
import com.elhady.ijobs.di.appModule
import com.elhady.ijobs.di.persistenceModule
import com.elhady.ijobs.di.repositoryModule
import com.elhady.ijobs.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by islam elhady on 22-Mar-21.
 */
class App: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(persistenceModule)
        }
    }
}