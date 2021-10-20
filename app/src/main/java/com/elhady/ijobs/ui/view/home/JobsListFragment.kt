package com.elhady.ijobs.ui.view.home

import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.elhady.ijobs.R
import com.elhady.ijobs.data.local.toFavouriteJobsEntity
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.FragmentListJobsBinding
import com.elhady.ijobs.ui.base.BaseFragmentWithBusiness
import com.elhady.ijobs.ui.base.ViewState
import com.elhady.ijobs.utils.afterTextChanged
import com.elhady.ijobs.utils.clear
import com.elhady.ijobs.utils.hide
import com.elhady.ijobs.utils.show
import kotlinx.android.synthetic.main.fragment_list_jobs.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by islam elhady on 20-Oct-21.
 */
class JobsListFragment :
    BaseFragmentWithBusiness<FragmentListJobsBinding, JobsViewModel>(R.layout.fragment_list_jobs) {

    private var jobsAdapter: JobsAdapter? = null
    private var jobsList = mutableListOf<Job>()
    override val viewModel: JobsViewModel by viewModel()

    override fun setup() {
        setupAdapter()
        refreshAllJobs()

        jobSearch.setOnClickListener {
            hide(textSearch, imgSearch)
            show(backImage, searchResultsET)
        }

        swipeRefresh.apply {
            setOnRefreshListener { refreshAllJobs() }
            setColorSchemeResources(R.color.blue_200)
        }

        shimmer.visibility = View.INVISIBLE

        backImage.setOnClickListener {
            show(textSearch, imgSearch)
            hide(backImage, searchResultsET)
            searchResultsET.clear()
        }

        searchResultsET.afterTextChanged {
            filter(it)
        }

        settings.setOnClickListener {
            view?.findNavController()
                ?.navigate(JobsListFragmentDirections.actionListJobsFragmentToSettingsFragment())
        }
    }


    override fun render(state: ViewState) {
        when (state) {
            is JobsViewState.OnJobsResponse -> {
                jobsList.clear()
                jobsList.addAll(state.data?.toMutableList()!!)
                if (searchResultsET.visibility == View.VISIBLE)
                    filter(searchResultsET.text.toString())
                else
                    jobsAdapter?.submitList(jobsList)
            }
        }
    }

    private fun setupAdapter() {

        jobsAdapter = JobsAdapter(JobItemClick { it, version ->
            when (version) {
                0 -> findNavController().navigate(
                    JobsListFragmentDirections.actionListJobsFragmentToDetailsJobsFragment(it))
                1 -> viewModel.addJobToFavorite(it.toFavouriteJobsEntity())
            }
        })
        // Sets the adapter of the RecyclerView
        jobsRV.adapter = jobsAdapter
    }

    private fun filter(text: String) {
        val filteredList: ArrayList<Job> = ArrayList()
        for (item in jobsList) {
            if (item.title?.toLowerCase(Locale.ROOT)
                    ?.contains(text.toLowerCase(Locale.ROOT)) == true
            ) {
                filteredList.add(item)
            }
        }
        jobsAdapter?.submitList(filteredList.toMutableList())
    }

    private fun refreshAllJobs() {
        viewModel.getJobs()
    }
}