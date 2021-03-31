package com.elhady.ijobs.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elhady.ijobs.data.model.Jobs

/**
 * Created by islam elhady on 30-Mar-21.
 */

@Dao
interface JobsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(jobs: List<Jobs>)

    @Query("SELECT * FROM ijobs_db")
    fun getAllJobs() : LiveData<List<Jobs>>

}