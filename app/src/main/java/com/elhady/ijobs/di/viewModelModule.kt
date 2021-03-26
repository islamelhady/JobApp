package com.elhady.ijobs.di

import com.elhady.ijobs.ui.viewmodel.MainViewModel
import org.koin.dsl.module

/**
 * Created by islam elhady on 24-Mar-21.
 */
val viewModelModule = module {
    single {
        MainViewModel(get(), get())
    }
}