package com.elhady.ijobs.di

import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.data.remote.ApiService.Companion.BASE_URL
import com.elhady.ijobs.data.repository.IjobRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by islam elhady on 22-Mar-21.
 */
val appModule = module {


    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
            .build()
            .create(ApiService::class.java)
    }
    single {
        IjobRepository(get())
    }


}