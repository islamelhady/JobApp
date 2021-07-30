package com.elhady.ijobs.ui.view.favourite

import androidx.lifecycle.ViewModel
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.data.repository.IjobRepository
import kotlinx.coroutines.runBlocking

class FavouriteViewModel(val repository: IjobRepository) : ViewModel() {

    val favoriteJobList = repository.getFavoriteJobs()


    fun toggleFavorites(job: Job) = runBlocking {
        repository.toggleFavorites(job)
    }
}