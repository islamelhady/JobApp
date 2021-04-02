package com.elhady.ijobs.data.remote

import com.elhady.ijobs.data.model.JobsResponse

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ApiHelperImpl(private val apiService: ApiService) {
    fun fecchJobsList(onResult: (response: ApiResponse<JobsResponse>) -> Unit) {
        this.apiService.fetchJobsList("api")
    }
}