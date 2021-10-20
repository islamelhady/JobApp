package com.elhady.ijobs.data.remote

import com.elhady.ijobs.data.model.JobsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by islam elhady on 22-Mar-21.
 */
interface ApiService {
    @GET("remote-jobs")
    suspend fun getAllJobs(@Query("limit") limit: String): Response<JobsResponse>


    companion object{
        const val BASE_URL = "https://remotive.io/api/"
    }
}