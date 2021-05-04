package com.elhady.ijobs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elhady.ijobs.data.model.Jobs

/**
 * Created by islam elhady on 28-Mar-21.
 */
@Database(entities = [Jobs::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jobsDao(): JobsDao
}