package com.elhady.ijobs.ui.view.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.elhady.ijobs.R
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.FragmentListJobsBinding
import com.elhady.ijobs.ui.adapter.IjobAdapter
import com.elhady.ijobs.ui.adapter.JobClick
import com.elhady.ijobs.utils.*
import kotlinx.android.synthetic.main.fragment_list_jobs.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ListJobsFragment : Fragment() {

    private lateinit var binding: FragmentListJobsBinding
    private val viewModel: IjobViewModel by viewModel()
    private var adapter: IjobAdapter? = null
    private var jobsList = mutableListOf<Job>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListJobsBinding.inflate(inflater)
        setupAdapter()
        setupObservers()
        binding.swipeRefresh.setOnRefreshListener { refreshAllJobs() }
        binding.swipeRefresh.setColorSchemeResources(R.color.blue_200)
        binding.shimmer.visibility = View.VISIBLE
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            listJobs = this@ListJobsFragment


            conSearch.setOnClickListener {
                hide(textSearch, imgSearch)
                show(backImage, searchResultsET)
            }

            backImage.setOnClickListener {
                show(textSearch, imgSearch)
                hide(backImage, searchResultsET)
                searchResultsET.clear()
            }

            searchResultsET.afterTextChanged {
                filter(it)
            }
        }
    }


    private fun setupAdapter() {
        adapter = IjobAdapter(JobClick { it ->
            val toDetailsFragment = it.let {
                ListJobsFragmentDirections.actionListJobsFragmentToDetailsJobsFragment(it)
            }
            findNavController().navigate(toDetailsFragment)
        })
        // Sets the adapter of the RecyclerView
        binding.recyclerView.adapter = adapter
        postponeEnterTransition()
        binding.recyclerView.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }


    private fun setupObservers() {
        viewModel.jobLiveData.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is State.Loading -> binding.swipeRefresh.isRefreshing = true
                is State.Success -> {
                    jobsList.clear()
                    jobsList.addAll(state.data.jobs?.toMutableList()!!)
                    if (searchResultsET.visibility == View.VISIBLE)
                        filter(searchResultsET.text.toString())
                    else
                        adapter?.submitList(jobsList)
                    binding.swipeRefresh.isRefreshing = false
                    binding.shimmer.visibility = View.GONE
                }
                is State.Error -> {
                    binding.swipeRefresh.isRefreshing = false
                    binding.shimmer.visibility = View.GONE
                    makeToast(state.message)
                }
            }
        })

    }

    /**
     * Navigate to the search screen to search the jobs .
     */
    fun goToSearchJobs() {
//        findNavController().navigate(R.id.action_listJobsFragment_to_searchFragment)
    }

    /**
     * Set Night Mode .
     */
    fun nightMode() {
        // Get new mode.
        val mode =
            if ((resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                Configuration.UI_MODE_NIGHT_NO
            ) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            }

        // Change UI Mode
        AppCompatDelegate.setDefaultNightMode(mode)
        true
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
        adapter?.submitList(filteredList.toMutableList())
    }


    override fun onResume() {
        super.onResume()
        refreshAllJobs()
    }

    private fun refreshAllJobs() {
        viewModel.getJobs()
    }
}