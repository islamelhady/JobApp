package com.elhady.ijobs.ui.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.elhady.ijobs.R
import com.elhady.ijobs.databinding.FragmentListJobsBinding
import com.elhady.ijobs.ui.adapter.IjobAdapter
import com.elhady.ijobs.utils.State
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ListJobsFragment : Fragment() {

    private lateinit var binding: FragmentListJobsBinding
    private val viewModel: IjobViewModel by viewModel()
    private var adapter: IjobAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListJobsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.swipeRefresh.setColorSchemeResources(R.color.blue_200)
        setupAdapter()
        setupObservers()
        binding.swipeRefresh.setOnRefreshListener {
            refreshAllJobs()
        }
        return binding.root

    }


    private fun setupAdapter() {
        adapter = IjobAdapter()
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
                    if (state.data.results?.isNotEmpty()!!)
                        adapter?.submitList(state.data.results)
                    else
                        Toast.makeText(activity, "NO DATA", Toast.LENGTH_SHORT).show()
                    binding.swipeRefresh.isRefreshing = false
                }
                is State.Error -> {
                    binding.swipeRefresh.isRefreshing = false
                    Toast.makeText(activity, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    override fun onResume() {
        super.onResume()
        refreshAllJobs()
    }

    private fun refreshAllJobs() {
        viewModel.getJobs()
    }
}