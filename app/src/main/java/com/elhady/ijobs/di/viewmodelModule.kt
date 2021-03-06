package com.elhady.ijobs.di

import com.elhady.ijobs.ui.view.favourite.FavouriteViewModel
import com.elhady.ijobs.ui.view.home.JobsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        JobsViewModel(get(), get())
    }
    viewModel {
        FavouriteViewModel(get(), get())
    }
}