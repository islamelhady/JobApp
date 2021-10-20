package com.elhady.ijobs.di

import android.content.Context
import com.elhady.ijobs.data.local.FavoriteJobsDatabase
import org.koin.dsl.module

/**
 * Created by islam elhady on 11-Jul-21.
 */
val persistenceModule = module {

    fun provideAppLocalDatabase(context: Context): FavoriteJobsDatabase {
        return FavoriteJobsDatabase.getAppDatabase(context)
    }

    // Room Database
    single { provideAppLocalDatabase(get()) }
}