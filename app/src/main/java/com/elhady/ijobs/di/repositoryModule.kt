package com.elhady.ijobs.di

import com.elhady.ijobs.data.repository.JobRepository
import org.koin.dsl.module

/**
 * Created by islam elhady on 24-Mar-21.
 */
val repositoryModule = module {
    single {
        JobRepository(get())
    }
}