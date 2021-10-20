package com.elhady.ijobs.ui.view.home

import com.elhady.ijobs.data.local.JobEntity
import com.elhady.ijobs.ui.base.BaseViewModel
import com.elhady.ijobs.utils.coroutines.ContextProvider
import kotlinx.coroutines.flow.collect

/**
 * Created by islam elhady on 20-Oct-21.
 */
class JobsViewModel(
    contextProvider: ContextProvider,
    private val jobsRepository: JobsRepository
) :
    BaseViewModel(contextProvider = contextProvider) {

    fun getJobs() {
        launchBlock(showLoading = true) {
            jobsRepository.getAllJobs().collect {
            }
        }
    }

    fun addJobToFavorite(job: JobEntity) {
        launchBlock(showLoading = true) {
            jobsRepository.checkItem(job).collect {
                if (it)
                    setState(JobsViewState.OnAddingFavoriteResponse(false))
                else
                    jobsRepository.addJobToFavoriteList(job).collect {
                        setState(JobsViewState.OnAddingFavoriteResponse(true))
                    }
            }
        }
    }
}


