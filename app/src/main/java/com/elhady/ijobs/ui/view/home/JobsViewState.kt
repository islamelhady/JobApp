package com.elhady.ijobs.ui.view.home

import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.ui.base.ViewState

/**
 * Created by islam elhady on 20-Oct-21.
 */
sealed class JobsViewState : ViewState() {
    data class OnJobsResponse(val data: List<Job>?) : Loaded<List<Job>?>(data)
    data class OnAddingFavoriteResponse(val data: Boolean?) : Loaded<Boolean?>(data)
}