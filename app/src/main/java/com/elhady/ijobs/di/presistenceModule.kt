package com.elhady.ijobs.di

import androidx.room.Room
import com.elhady.ijobs.R
import com.elhady.ijobs.data.local.IJobsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by islam elhady on 11-Jul-21.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), IJobsDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<IJobsDatabase>().iJobDao() }
}