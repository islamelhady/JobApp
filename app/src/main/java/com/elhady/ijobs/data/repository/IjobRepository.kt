package com.elhady.ijobs.data.repository

import com.elhady.ijobs.data.local.dao.IJobsDao
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.data.model.RemoteJob
import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * Created by islam elhady on 22-Mar-21.
 */
class IjobRepository(private val apiService: ApiService, private val iJobsDao: IJobsDao) {

    fun getAllJobs(): Flow<State<RemoteJob>> {
        return object : NetworkBoundRepository<RemoteJob>() {
            override suspend fun fetchFromRemote(): Response<RemoteJob> =
                apiService.getAllJobs("10")
        }.asFlow().flowOn(Dispatchers.IO)
    }

    fun getFavoriteJobs() = iJobsDao.getAllFavorites()

    suspend fun toggleFavorites(job: Job): Int = withContext(Dispatchers.IO) {
        if (job.isFavorite) {
            iJobsDao.removeFromFavorites(job.id)
        } else {
            iJobsDao.addToFavorites(job.id)
        }
    }
}