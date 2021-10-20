package com.elhady.ijobs.ui.view.home

import com.elhady.ijobs.data.remote.ApiService
import com.elhady.ijobs.ui.base.BaseRepository
import com.elhady.ijobs.utils.coroutines.ContextProvider

/**
 * Created by islam elhady on 20-Oct-21.
 */
class JobsRepository(
    contextProvider: ContextProvider,
    private val apiService: ApiService
) :
    BaseRepository(contextProvider) {

    fun getAllJobs() = networkHandler {
        apiService.getAllJobs("10")
    }
}