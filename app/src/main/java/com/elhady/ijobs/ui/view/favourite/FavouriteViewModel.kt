package com.elhady.ijobs.ui.view.favourite

import com.elhady.ijobs.data.model.toJobViewResponse
import com.elhady.ijobs.ui.base.BaseViewModel
import com.elhady.ijobs.utils.coroutines.ContextProvider
import kotlinx.coroutines.flow.collect

/**
 * Created by islam elhady on 20-Oct-21.
 */
class FavouriteViewModel(
    contextProvider: ContextProvider,
    private val favoriteRepository: FavoriteRepository
) : BaseViewModel(contextProvider) {

    fun getFavoriteJobs() {
        launchBlock {
            favoriteRepository.getJobList().collect { flow ->
                flow.collect { list ->
                    setState(FavoriteJobsViewState.OnJobResponse(list.map { it.toJobViewResponse() }))
                }
            }
        }
    }

    fun removeJobFromFavorite(id: Int) {
        launchBlock(showLoading = true) {
            favoriteRepository.deleteJobFromFavoriteList(id).collect {
                if (it != -1)
                    setState(FavoriteJobsViewState.OnDeletingFavoriteResponse(true))
            }
        }
    }
}