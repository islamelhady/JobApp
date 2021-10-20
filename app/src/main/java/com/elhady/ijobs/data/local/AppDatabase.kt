package com.elhady.ijobs.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by islam elhady on 11-Jul-21.
 */
@Database(entities = [JobEntity::class], version = 1, exportSchema = false)
abstract class FavoriteJobsDatabase : RoomDatabase() {
    abstract val favoriteJobsDao: FavoriteJobsDao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteJobsDatabase? = null

        fun getAppDatabase(context: Context): FavoriteJobsDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    FavoriteJobsDatabase::class.java,
                    "favoriteJobsDB"
                ).build()
            }.also {
                INSTANCE = it
            }
        }
    }
}