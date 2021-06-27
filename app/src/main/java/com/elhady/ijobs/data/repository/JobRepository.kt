package com.elhady.ijobs.data.repository

import com.elhady.ijobs.data.model.AllJobsResponse
import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * Created by islam elhady on 22-Mar-21.
 */
class JobRepository(private val apiService: ApiService) {

    fun getAllJobs(): Flow<State<AllJobsResponse>> {
        return object : NetworkBoundRepository<AllJobsResponse>() {
            override suspend fun fetchFromRemote(): Response<AllJobsResponse> =
                apiService.getAllJobs("api")
        }.asFlow().flowOn(Dispatchers.IO)
    }


}