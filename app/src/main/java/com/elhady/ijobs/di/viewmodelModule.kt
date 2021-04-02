package com.elhady.ijobs.di

import com.elhady.ijobs.ui.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}