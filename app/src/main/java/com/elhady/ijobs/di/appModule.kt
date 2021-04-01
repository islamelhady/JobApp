package com.elhady.ijobs.di

import com.elhady.ijobs.data.remote.ApiHelper
import com.elhady.ijobs.data.remote.ApiHelperImpl
import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.utils.BASE_URL
import com.elhady.ijobs.utils.NetworkHelper
import com.elhady.ijobs.utils.timeoutConnect
import com.elhady.ijobs.utils.timeoutRead
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import org.koin.android.ext.koin.androidContext

/**
 * Created by islam elhady on 22-Mar-21.
 */
val appModule = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

//    single {
//        NetworkHelper(androidContext())
//    }

//    single<ApiHelper> {
//        return@single ApiHelperImpl(get())
//    }
    single {
        ApiHelperImpl(get())
    }

}