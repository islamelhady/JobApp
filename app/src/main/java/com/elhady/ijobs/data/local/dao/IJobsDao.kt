package com.elhady.ijobs.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elhady.ijobs.data.model.Job
import kotlinx.coroutines.flow.Flow

/**
 * Created by islam elhady on 11-Jul-21.
 */
@Dao
interface IJobsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addJob(posts: List<Job>)

    @Query("SELECT * FROM job")
    fun getAllJobs(): Flow<List<Job>>

}