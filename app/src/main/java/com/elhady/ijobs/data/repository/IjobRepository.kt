package com.elhady.ijobs.data.repository

import com.elhady.ijobs.data.model.AllIjobsResponse
import com.elhady.ijobs.data.model.Ijob
import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * Created by islam elhady on 22-Mar-21.
 */
class IjobRepository(private val apiService: ApiService) {

    fun getAllJobs(): Flow<State<AllIjobsResponse>> {
        return object : NetworkBoundRepository<AllIjobsResponse>() {
            override suspend fun fetchFromRemote(): Response<AllIjobsResponse> =
                apiService.getAllJobs()
        }.asFlow().flowOn(Dispatchers.IO)
    }


}