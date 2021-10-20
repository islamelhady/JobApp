package com.elhady.ijobs.ui.view.favourite

import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.ui.base.ViewState

/**
 * Created by islam elhady on 20-Oct-21.
 */
sealed class FavoriteJobsViewState : ViewState() {
    data class OnJobResponse(val data: List<Job>?) : Loaded<List<Job>?>(data)
    data class OnDeletingFavoriteResponse(val data: Boolean?) : Loaded<Boolean?>(data)
}
