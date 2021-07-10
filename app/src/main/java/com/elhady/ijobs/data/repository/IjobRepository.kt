package com.elhady.ijobs.data.repository

import com.elhady.ijobs.data.model.RemoteJob
import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * Created by islam elhady on 22-Mar-21.
 */
class IjobRepository(private val apiService: ApiService) {

    fun getAllJobs(): Flow<State<RemoteJob>> {
        return object : NetworkBoundRepository<RemoteJob>() {
            override suspend fun fetchFromRemote(): Response<RemoteJob> =
                apiService.getAllJobs("10")
        }.asFlow().flowOn(Dispatchers.IO)
    }

    fun searchJobs(query: String?): Flow<State<RemoteJob>>{
        return object : NetworkBoundRepository<RemoteJob>(){
            override suspend fun fetchFromRemote(): Response<RemoteJob> =
                apiService.searchJobs(query)
        }.asFlow().flowOn(Dispatchers.IO)
    }


}