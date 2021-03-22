package com.elhady.ijobs.data.repository

import com.elhady.ijobs.data.remote.ApiHelper

/**
 * Created by islam elhady on 22-Mar-21.
 */
class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getJobs() = apiHelper.fetchJobsList()
}