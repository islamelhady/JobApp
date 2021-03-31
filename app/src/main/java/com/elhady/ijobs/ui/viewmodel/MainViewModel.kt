package com.elhady.ijobs.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.data.repository.MainRepository
import com.elhady.ijobs.utils.NetworkHelper
import com.elhady.ijobs.utils.Resource
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Created by islam elhady on 23-Mar-21.
 */
class MainViewModel(
    private val mainRepository: MainRepository, private val networkHelper: NetworkHelper
) : ViewModel() {


//    private val _jobs = MutableLiveData<Resource<List<Jobs>>>()
//    val jobs: LiveData<Resource<List<Jobs>>>
//        get() = _jobs

//    val jobs: LiveData<List<Jobs>> = jobsDao.getAllJobs()

    val jobs = mainRepository.jobsList

    init {
        fetchJobs()
    }

//    private fun fetchJobs() {
//        viewModelScope.launch {
//            _jobs.postValue(Resource.loading(null))
////            if (networkHelper.isNetworkConnected()) {
//                mainRepository.getJobs().let {
////                    if (it.isSuccessful) {
//                        _jobs.postValue(Resource.success(it))
////                    } else _jobs.postValue(Resource.error(it.errorBody().toString(), null))
//                }
////            } else _jobs.postValue(Resource.error("No internet connection", null))
//        }
//    }

    private fun fetchJobs() {
        viewModelScope.launch {
            mainRepository.refreshListJobs()
        }
    }

    companion object {
        private const val JobsKey = "Jobs"
        fun createArguments(jobs: Jobs): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(JobsKey, jobs)
            return bundle
        }
    }
}

