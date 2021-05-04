package com.elhady.ijobs.di

import androidx.room.Room
import com.elhady.ijobs.R
import com.elhady.ijobs.data.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by islam elhady on 28-Mar-21.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().jobsDao()
    }
}