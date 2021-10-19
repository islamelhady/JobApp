package com.elhady.ijobs.ui.base

import com.elhady.ijobs.utils.errors.ApplicationException

/**
 * Created by islam elhady on 19-Oct-21.
 */
abstract class ViewState {
    object Initial : ViewState()
    object Empty : ViewState()
    data class Loading(val loading: Boolean) : ViewState()
    data class Error(val exception: ApplicationException) : ViewState()
    abstract class Loaded<out T>(val r: T) : ViewState()
}