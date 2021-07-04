package com.elhady.ijobs.di

import com.elhady.ijobs.ui.view.home.IjobViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        IjobViewModel(get())
    }
}