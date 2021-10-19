package com.elhady.ijobs.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

/**
 * Created by islam elhady on 19-Oct-21.
 */
abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel>(private val layoutId: Int) :
    AppCompatActivity() {

    protected abstract val viewModel: VM

    /**
     *  in case we needed to access the views
     */
    lateinit var binder: VB
    private lateinit var loaderDialog: LoaderDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, layoutId)
        loaderDialog = LoaderDialog[this]
        setup()
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                baseRender(it)
            }
        }
    }

    abstract fun setup()

    private fun baseRender(state: ViewState) {
        when (state) {
            is ViewState.Initial -> hideLoading()
            is ViewState.Loading -> if (state.loading) showLoading() else hideLoading()
            is ViewState.Empty -> {/*empty*/
            }
            is ViewState.Error -> showError(state)
            else -> {
                hideLoading()
                render(state)
            }
        }
    }

    abstract fun render(state: ViewState)

    fun showLoading() {
        loaderDialog.show()
    }

    fun hideLoading() {
        loaderDialog.hide()
    }

    fun showError(error: ViewState.Error) {
        hideLoading()
        val errorMessage = error.exception.errorMessage
            ?: run {
                return@run if (error.exception.errorMessageRes != null) {
                    getString(error.exception.errorMessageRes)
                } else null
            }
            ?: "Unexpected Error"
        if (errorMessage.isNotEmpty())
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}