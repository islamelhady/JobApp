package com.elhady.ijobs.ui.view.jobs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.elhady.ijobs.R
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.databinding.FragmentListJobsBinding
import com.elhady.ijobs.ui.adapter.MainAdapter
import com.elhady.ijobs.ui.viewmodel.MainViewModel
import com.elhady.ijobs.ui.viewmodel.MainViewModel.Companion.createArguments
import com.elhady.ijobs.utils.Status
import kotlinx.android.synthetic.main.fragment_list_jobs.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 22-Mar-21.
 */
class ListJobsFragment : Fragment(), MainAdapter.OnItemJobClickListener {

    private lateinit var binding: FragmentListJobsBinding
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListJobsBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupUI()
    }

    private fun setupObservers() {
        mainViewModel.jobs.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { jobs -> retrieveList(jobs) }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
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

}