package com.elhady.ijobs.data.remote

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ApiHelperImpl(private val apiService: ApiService) : ApiHelper() {

    suspend fun fetchJobsList() = getResult { apiService.fetchJobsList("api") }
}