package com.elhady.ijobs.ui.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhady.ijobs.R
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.FragmentListJobsBinding
import com.elhady.ijobs.ui.adapter.JobAdapter
import com.elhady.ijobs.ui.adapter.JobClick
import kotlinx.android.synthetic.main.fragment_list_jobs.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ListJobsFragment : Fragment(){

    private lateinit var binding: FragmentListJobsBinding
    private val viewModel: JobViewModel by viewModel()
    private var adapter: JobAdapter? = null


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
//        return binding.apply {
//            viewModel = this@ListJobsFragment.mainViewModel
//            lifecycleOwner = this@ListJobsFragment
//        }
            return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupObservers()
//        setupUI()

//        showJobs()
    }

//    private fun showJobs() {
//        recyclerView.removeAllViewsInLayout()
//        mainViewModel.pokemonListLiveData.value?.let {
//            retrieveList(it)
//        }
////        bindAdapterPokemonsList(recyclerView, viewModel.pokemonListLiveData.value)
//    }


    private fun setupAdapter() {
        adapter = JobAdapter(JobClick{it, view ->

        })
    }

    private fun setupObservers() {

    }

    override fun onResume() {
        super.onResume()
        refreshAllJobs()
    }

    private fun refreshAllJobs() {
        viewModel.getJobs()
    }
//    private fun setupUI() {
////        recyclerView.layoutManager = LinearLayoutManager(activity)
//        adapter = JobAdapter(arrayListOf(), this)
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                (recyclerView.layoutManager as LinearLayoutManager).orientation
//            )
//        )
//        recyclerView.adapter = adapter
//    }

//    private fun retrieveList(jobs: List<Job>) {
//        adapter.apply {
//            addJobsList(jobs)
//            notifyDataSetChanged()
//        }
//    }

//    override fun onItemClick(jobs: Job, position: Int) {
//        findNavController().navigate(R.id.detailsJobsFragment, createArguments(jobs))
//
//    }


//    private fun updateRefreshLayout(refresh: Boolean) {
//        swipeRefresh.isRefreshing = refresh
//    }
}