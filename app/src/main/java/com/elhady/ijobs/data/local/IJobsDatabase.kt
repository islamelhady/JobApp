package com.elhady.ijobs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elhady.ijobs.data.local.dao.IJobsDao
import com.elhady.ijobs.data.model.Job

/**
 * Created by islam elhady on 11-Jul-21.
 */
@Database(entities = [Job::class], version = 1, exportSchema = false)
abstract class IJobsDatabase : RoomDatabase() {
    abstract fun iJobDao(): IJobsDao
}
