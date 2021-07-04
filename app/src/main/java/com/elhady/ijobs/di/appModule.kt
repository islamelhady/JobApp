package com.elhady.ijobs.di

import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.data.repository.IjobRepository
import com.elhady.ijobs.utils.BASE_URL
import com.elhady.ijobs.utils.timeoutConnect
import com.elhady.ijobs.utils.timeoutRead
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by islam elhady on 22-Mar-21.
 */
val appModule = module {

//    single {
//        OkHttpClient.Builder()
//            .connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
//            .readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
//            .build()
//    }

    single {
        Retrofit.Builder()
//            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
            .build()
            .create(ApiService::class.java)
    }
    single {
        IjobRepository(get())
    }


}