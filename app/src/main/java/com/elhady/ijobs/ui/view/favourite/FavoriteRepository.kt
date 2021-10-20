package com.elhady.ijobs.ui.view.favourite

import com.elhady.ijobs.data.local.FavoriteJobsDatabase
import com.elhady.ijobs.ui.base.BaseRepository
import com.elhady.ijobs.utils.coroutines.ContextProvider

/**
 * Created by islam elhady on 20-Oct-21.
 */
class FavoriteRepository(
    contextProvider: ContextProvider,
    private val favoriteJobsDatabase: FavoriteJobsDatabase
) : BaseRepository(contextProvider) {

    fun getJobList() = networkHandler {
        favoriteJobsDatabase.favoriteJobsDao.getJobs()
    }


    suspend fun deleteJobFromFavoriteList(id : Int) = networkHandler {
        favoriteJobsDatabase.favoriteJobsDao.deleteById(id)
    }
}