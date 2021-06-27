package com.elhady.ijobs.data.repository

/**
 * Created by islam elhady on 22-Mar-21.
 */
class JobRepository(private val apiHelper: ApiHelper) {

    suspend fun getJobs() = apiHelper.fetchJobsList()
}