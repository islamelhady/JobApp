package com.elhady.ijobs.data.repository

import com.elhady.ijobs.data.local.JobsDao
import com.elhady.ijobs.data.remote.ApiHelperImpl
import com.elhady.ijobs.utils.performGetOperation

/**
 * Created by islam elhady on 22-Mar-21.
 */
class MainRepository(
    private val remoteSource: ApiHelperImpl,
    private val localSource: JobsDao
) {

    fun fetchJobsList() = performGetOperation(
        databaseQuery = { localSource.getAllJobs() },
        networkCall = { remoteSource.fetchJobsList() },
        saveCallResult = {localSource.insertAll(it)}
    )
//    suspend fun getJobs() = apiHelper.fetchJobsList()


//    suspend fun refreshVideos() {
//        withContext(Dispatchers.IO) {
//            Timber.d("refresh videos is called")
//            val playlist = DevByteNetwork.devbytes.getPlaylist()
//            database.videoDao.insertAll(playlist.asDatabaseModel())
//        }
//
//    }

//    val jobsList: LiveData<List<Jobs>> = jobsDao.getAllJobs()
//
//    suspend fun refreshListJobs(){
//        withContext(Dispatchers.IO){
//            Log.d("repo","refresh videos is called")
//            val listJobs = apiHelper.fetchJobsList()
//            jobsDao.insertAll(listJobs)
//        }
//    }
}