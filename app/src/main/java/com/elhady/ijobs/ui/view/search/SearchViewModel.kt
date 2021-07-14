package com.elhady.ijobs.ui.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elhady.ijobs.data.model.RemoteJob
import com.elhady.ijobs.data.repository.IjobRepository
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by islam elhady on 09-Jul-21.
 */
class SearchViewModel(val repository: IjobRepository) : ViewModel() {

    private val _allSearchJob = MutableLiveData<State<RemoteJob>>()
    val allSearchJob: LiveData<State<RemoteJob>>
    get() = _allSearchJob


    fun getSearchJob(query: String) {
        viewModelScope.launch {
            repository.searchJobs(query).collect {
                _allSearchJob.value = it
            }
        }
    }
}