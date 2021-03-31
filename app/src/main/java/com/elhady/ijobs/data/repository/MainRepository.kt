package com.elhady.ijobs.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.elhady.ijobs.data.local.JobsDao
import com.elhady.ijobs.data.local.JobsDatabase
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.data.remote.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by islam elhady on 22-Mar-21.
 */
class MainRepository(
    private val apiHelper: ApiHelper,
    private val jobsDao: JobsDao
) {
//    suspend fun getJobs() = apiHelper.fetchJobsList()


//    suspend fun refreshVideos() {
//        withContext(Dispatchers.IO) {
//            Timber.d("refresh videos is called")
//            val playlist = DevByteNetwork.devbytes.getPlaylist()
//            database.videoDao.insertAll(playlist.asDatabaseModel())
//        }
//
//    }

    val jobsList: LiveData<List<Jobs>> = jobsDao.getAllJobs()

    suspend fun refreshListJobs(){
        withContext(Dispatchers.IO){
            Log.d("repo","refresh videos is called")
            val listJobs = apiHelper.fetchJobsList()
            jobsDao.insertAll(listJobs)
        }
    }
}