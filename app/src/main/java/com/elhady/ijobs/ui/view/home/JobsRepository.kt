package com.elhady.ijobs.ui.view.home

import com.elhady.ijobs.data.local.FavoriteJobsDatabase
import com.elhady.ijobs.data.local.JobEntity
import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.ui.base.BaseRepository
import com.elhady.ijobs.utils.coroutines.ContextProvider

/**
 * Created by islam elhady on 20-Oct-21.
 */
class JobsRepository(
    contextProvider: ContextProvider,
    private val apiService: ApiService,
    private val favoriteJobsDatabase: FavoriteJobsDatabase
) :
    BaseRepository(contextProvider) {

    fun getAllJobs() = networkHandler {
        apiService.getAllJobs("10")
    }

    fun checkItem(job: JobEntity) = networkHandler {
        favoriteJobsDatabase.favoriteJobsDao.exists(job.id)
    }

    suspend fun addJobToFavoriteList(job: JobEntity) = networkHandler {
        favoriteJobsDatabase.favoriteJobsDao.insert(job)
    }
}