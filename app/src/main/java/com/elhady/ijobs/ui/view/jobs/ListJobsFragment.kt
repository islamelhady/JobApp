package com.elhady.ijobs.ui.view.jobs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.elhady.ijobs.R
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.databinding.FragmentListJobsBinding
import com.elhady.ijobs.ui.adapter.MainAdapter
import com.elhady.ijobs.ui.viewmodel.MainViewModel
import com.elhady.ijobs.ui.viewmodel.MainViewModel.Companion.createArguments
import kotlinx.android.synthetic.main.fragment_list_jobs.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ListJobsFragment : Fragment(), MainAdapter.OnItemJobClickListener,
    SwipeRefreshLayout.OnRefreshListener {

    private lateinit var binding: FragmentListJobsBinding
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListJobsBinding.inflate(inflater, container, false)
        return binding.apply {
            viewModel = this@ListJobsFragment.mainViewModel
            lifecycleOwner = this@ListJobsFragment
        }.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupUI()

//        showJobs()
    }

//    private fun showJobs() {
//        recyclerView.removeAllViewsInLayout()
//        mainViewModel.pokemonListLiveData.value?.let {
//            retrieveList(it)
//        }
////        bindAdapterPokemonsList(recyclerView, viewModel.pokemonListLiveData.value)
//    }

    private fun setupObservers() {
        mainViewModel.pokemonListLiveData.observe(viewLifecycleOwner, Observer {

                retrieveList(it)

        })
    }


    private fun setupUI() {
//        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(arrayListOf(), this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun retrieveList(jobs: List<Jobs>) {
        adapter.apply {
            addJobsList(jobs)
            notifyDataSetChanged()
        }
    }

    override fun onItemClick(jobs: Jobs, position: Int) {
        findNavController().navigate(R.id.detailsJobsFragment, createArguments(jobs))

    }

    override fun onRefresh() {
//        setupObservers()
    }

    private fun updateRefreshLayout(refresh: Boolean) {
        swipeRefresh.isRefreshing = refresh
    }
}