package com.elhady.ijobs.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.elhady.ijobs.data.model.Job

/**
 * Created by islam elhady on 11-Jul-21.
 */
@Dao
interface IJobsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addJob(job: Job)

    @Query("update job set isFavorite = 1 where id = :jobId")
    fun addToFavorites(jobId: Int): Int

    @Query("update job set isFavorite = 0 where id = :jobId")
    fun removeFromFavorites(jobId: Int): Int

    @Query("select * from job where isFavorite = 1 ")
    fun getAllFavorites(): LiveData<List<Job>>

    @Query("SELECT * FROM job")
    fun getAllJobs(): LiveData<List<Job>>

}