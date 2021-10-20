package com.elhady.ijobs.di

import com.elhady.ijobs.ui.view.favourite.FavoriteRepository
import com.elhady.ijobs.ui.view.home.JobsRepository
import com.elhady.ijobs.utils.coroutines.ContextProvider
import org.koin.dsl.module

val repositoryModule = module {
    single {
        JobsRepository(get(), get(), get())
    }
    single {
        FavoriteRepository(get(), get())
    }
}

val contextProviderModule = module {
    single {
        ContextProvider.getInstance()
    }
}