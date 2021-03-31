package com.elhady.ijobs.di

import androidx.room.Room
import com.elhady.ijobs.R
import com.elhady.ijobs.data.local.JobsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by islam elhady on 25-May-21.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), JobsDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<JobsDatabase>().jobsDao() }
}