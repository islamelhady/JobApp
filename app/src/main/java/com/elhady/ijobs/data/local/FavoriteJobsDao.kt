package com.elhady.ijobs.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Created by islam elhady on 11-Jul-21.
 */
@Dao
interface FavoriteJobsDao {

    @Query("SELECT EXISTS (SELECT 1 FROM JobEntity WHERE id = :id)")
    suspend fun exists(id: Int?): Boolean

    @Query("select * from JobEntity")
    fun getJobs(): Flow<List<JobEntity>>

    @Insert
    suspend fun insert(job : JobEntity)

    @Query("DELETE FROM JobEntity WHERE id = :id")
    suspend fun deleteById(id: Int) :  Int
}