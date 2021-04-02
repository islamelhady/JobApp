package com.elhady.ijobs.data.local


/**
 * Created by islam elhady on 28-Mar-21.
 */
//@Dao
//interface JobsDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertJobsList(jobs: Jobs)
//
//    @Query("SELECT * FROM Jobs ORDER BY created_at DESC LIMIT 10")
//    fun getLiveData(): LiveData<List<Jobs>>
//
//    @Query("SELECT * FROM Jobs WHERE is_mark = 1 ORDER BY created_at DESC")
//    fun getLiveDataMarked(): LiveData<List<Jobs>>
//
//    @Query("SELECT * FROM Jobs WHERE id = :id")
//    fun getDataById(): Jobs
//
//    @Query("SELECT * FROM Jobs")
//    fun getJobsList(): List<Jobs>
//}