package com.elhady.ijobs.ui.view.favourite

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.elhady.ijobs.R
import com.elhady.ijobs.databinding.FavouriteFragmentBinding
import com.elhady.ijobs.ui.base.BaseFragmentWithBusiness
import com.elhady.ijobs.ui.base.ViewState
import com.elhady.ijobs.ui.view.home.JobItemClick
import com.elhady.ijobs.ui.view.home.JobsListFragmentDirections
import com.elhady.ijobs.utils.makeToast
import kotlinx.android.synthetic.main.favourite_fragment.*
import kotlinx.android.synthetic.main.toolbar_favorite.view.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 20-Oct-21.
 */
class FavouriteFragment :
    BaseFragmentWithBusiness<FavouriteFragmentBinding, FavouriteViewModel>(R.layout.favourite_fragment) {

    private var favoriteAdapter: FavoriteAdapter? = null
    override val viewModel: FavouriteViewModel by viewModel()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            back()
        }
    }

    override fun setup() {
        setupAdapter()
        viewModel.getFavoriteJobs()
        favoriteToolbar.favBackImage.setOnClickListener { back() }
    }

    private fun setupAdapter() {
        favoriteAdapter = FavoriteAdapter(JobItemClick { it, version ->
            when (version) {
                0 -> findNavController().navigate(
                    JobsListFragmentDirections.actionListJobsFragmentToDetailsJobsFragment(it)
                )
                1 -> viewModel.removeJobFromFavorite(it.id!!)
            }
        })
        favoriteRV.adapter = favoriteAdapter
    }

    override fun render(state: ViewState) {
        when (state) {
            is FavoriteJobsViewState.OnJobResponse -> {
                favoriteAdapter?.submitList(state.data)
            }
            is FavoriteJobsViewState.OnDeletingFavoriteResponse -> {
                makeToast(getString(R.string.job_deleted_msg))
            }
        }
    }

    private fun back() {
        view?.findNavController()?.navigateUp()
    }

}