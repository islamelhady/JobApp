package com.elhady.ijobs.data.repository

import androidx.lifecycle.MutableLiveData
import com.elhady.ijobs.data.local.JobsDao
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.data.remote.ApiHelperImpl
import com.elhady.ijobs.data.remote.ApiResponse
import com.elhady.ijobs.data.remote.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by islam elhady on 22-Mar-21.
 */
class MainRepository (
    private val remoteSource: ApiHelperImpl,
    private val localSource: JobsDao
) {

    suspend fun loadPokemonList(error: (String) -> Unit) =
        withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<Jobs>>()
            var jobs = emptyList<Jobs>()
            remoteSource.fecchJobsList { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        response.data?.let { data ->
                            jobs = data.jobs
                            localSource.insertAll(jobs)
                            liveData.postValue(jobs)
                        }
                    }
                    is ApiResponse.Failure.Error -> {
                        error(response.message())
                        jobs = getLocalJobs()
                        liveData.postValue(jobs)
                    }
                    is ApiResponse.Failure.Exception -> {
                        error(response.message())
                        jobs = getLocalJobs()
                        liveData.postValue(jobs)
                    }
                }
            }
            liveData.apply { postValue(jobs) }
        }

    private fun getLocalJobs() = localSource.getAllJobs()
}