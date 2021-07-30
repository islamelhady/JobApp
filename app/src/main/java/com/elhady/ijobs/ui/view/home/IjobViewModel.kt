package com.elhady.ijobs.ui.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.data.model.RemoteJob
import com.elhady.ijobs.data.repository.IjobRepository
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

/**
 * Created by islam elhady on 27-Jun-21.
 */
class IjobViewModel(val repository: IjobRepository) : ViewModel() {

    private val _allJobLiveData = MutableLiveData<State<RemoteJob>>()
    val jobLiveData: LiveData<State<RemoteJob>>
        get() = _allJobLiveData


    fun getJobs(){
        viewModelScope.launch {
            repository.getAllJobs().collect {
                _allJobLiveData.value = it
            }
        }
    }

    fun toggleFavorites(job: Job) = viewModelScope.launch {
        val oldValue = job.isFavorite
        repository.toggleFavorites(job)
        val snackBarMessage =
            if (oldValue)
                "${job.title} removed from favorites"
            else
                "${job.title} added to favorites"

//        snackBarEvents.value = Event(snackBarMessage)
    }
}


