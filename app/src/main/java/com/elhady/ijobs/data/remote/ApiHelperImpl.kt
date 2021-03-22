package com.elhady.ijobs.data.remote

import com.elhady.ijobs.data.model.Jobs
import retrofit2.Response

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun fetchJobsList(): Response<List<Jobs>> = apiService.fetchJobsList("api")
}