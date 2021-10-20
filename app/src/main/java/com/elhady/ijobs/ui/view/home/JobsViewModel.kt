package com.elhady.ijobs.ui.view.home

import com.elhady.ijobs.ui.base.BaseViewModel
import com.elhady.ijobs.utils.coroutines.ContextProvider
import kotlinx.coroutines.flow.collect

/**
 * Created by islam elhady on 20-Oct-21.
 */
class JobsViewModel(
    contextProvider: ContextProvider,
    private val repository: JobsRepository
) :
    BaseViewModel(contextProvider = contextProvider) {

    fun getJobs() {
        launchBlock(showLoading = true) {
            repository.getAllJobs().collect {
            }
        }
    }
}


