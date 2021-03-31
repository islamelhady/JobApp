package com.elhady.ijobs.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elhady.ijobs.data.model.Jobs

/**
 * Created by islam elhady on 30-Mar-21.
 */

@Database(entities = [Jobs::class], version = 1, exportSchema = false)
abstract class JobsDatabase : RoomDatabase() {

    abstract fun jobsDao(): JobsDao

//    companion object {
//        @Volatile
//        private var INSTANCE: JobsDatabase? = null
//
//        fun getInstance(context: Context): JobsDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        JobsDatabase::class.java,
//                        "ijobs_db"
//                    ).fallbackToDestructiveMigration()
//                        .build()
//
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
}