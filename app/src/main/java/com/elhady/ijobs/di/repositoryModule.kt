package com.elhady.ijobs.di

import com.elhady.ijobs.data.repository.MainRepository

/**
 * Created by islam elhady on 24-Mar-21.
 */
val repositoryModule = module {
    single {
        MainRepository(get())
    }
}