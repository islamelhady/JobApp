package com.elhady.ijobs.ui.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elhady.ijobs.data.model.AllIjobsResponse
import com.elhady.ijobs.data.model.Ijob
import com.elhady.ijobs.data.repository.IjobRepository
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

/**
 * Created by islam elhady on 27-Jun-21.
 */
class IjobViewModel(val repository: IjobRepository) : ViewModel() {

    private val _allJobLiveData = MutableLiveData<State<AllIjobsResponse>>()

    val jobLiveData: LiveData<State<AllIjobsResponse>>
        get() = _allJobLiveData

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun getJobs(){
        coroutineScope.launch {
            repository.getAllJobs().collect {
                _allJobLiveData.value = it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}


