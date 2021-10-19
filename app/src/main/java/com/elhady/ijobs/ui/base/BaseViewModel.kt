package com.elhady.ijobs.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elhady.ijobs.utils.coroutines.ContextProvider
import com.elhady.ijobs.utils.errors.ApplicationException
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by islam elhady on 19-Oct-21.
 */
abstract class BaseViewModel(private val contextProvider: ContextProvider) : ViewModel() {

    private val _state = MutableStateFlow<ViewState>(ViewState.Initial)
    val state: StateFlow<ViewState>
        get() = _state

    protected fun setState(state: ViewState) {
        _state.value = state
    }

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        setState(ViewState.Error(throwable as ApplicationException))
    }

    fun launchBlock(showLoading: Boolean = true, block: suspend CoroutineScope.() -> Unit) {
        setState(ViewState.Loading(showLoading))
        viewModelScope.launch(contextProvider.Main + coroutineExceptionHandler) {
            block.invoke(this)
        }
    }

    fun asyncBlock(showLoading: Boolean = true, block: suspend CoroutineScope.() -> Unit) {
        setState(ViewState.Loading(showLoading))
        viewModelScope.async(contextProvider.Main + coroutineExceptionHandler) {
            block.invoke(this)
        }
    }
}