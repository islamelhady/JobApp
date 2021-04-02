package com.elhady.ijobs.data.remote

import com.elhady.ijobs.data.model.JobsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by islam elhady on 22-Mar-21.
 */
interface ApiService {
    @GET("positions.json")
    fun fetchJobsList(@Query("description") api: String): Call<JobsResponse>
}