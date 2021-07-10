package com.elhady.ijobs.ui.view.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.elhady.ijobs.databinding.FragmentSearchBinding
import com.elhady.ijobs.ui.adapter.IjobAdapter
import com.elhady.ijobs.ui.adapter.JobClick
import com.elhady.ijobs.utils.State
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by islam elhady on 09-Jul-21.
 */
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private var adapter: IjobAdapter? = null
    private val viewModel: SearchViewModel by viewModel()
    private val args: SearchFragmentArgs by navArgs()
    private var querySearch: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        setupAdapter()
        setupObservers()
        searchJob()
//        querySearch = args.querySearch

//        viewModel.getSearchJob(querySearch)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }


    private fun setupAdapter() {
        adapter = IjobAdapter(JobClick{ it
            val toDetailsFragment = it.let {
                SearchFragmentDirections.actionSearchFragmentToDetailsJobsFragment(it)
            }
            findNavController().navigate(toDetailsFragment)
        })
        // Sets the adapter of the RecyclerView
        binding.searchList.adapter = adapter
        postponeEnterTransition()
        binding.searchList.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

    private fun setupObservers() {
        viewModel.allSearchJob.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
//                is State.Loading -> binding.searchLoader.visibility
                is State.Success -> {
                    if (state.data.jobs?.isNotEmpty()!!)
                        adapter?.submitList(state.data.jobs)
                    else
                        Toast.makeText(activity, "NO DATA", Toast.LENGTH_SHORT).show()
//                    binding.searchLoader.isGone
                }
                is State.Error -> {
//                    binding.searchLoader.isGone
                    Toast.makeText(activity, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun searchJob() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query.toString().isNotEmpty()) {
                    viewModel.getSearchJob(query.toString())
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

    }

    // clear views references to fix memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

}