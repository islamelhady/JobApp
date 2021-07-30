package com.elhady.ijobs.ui.view.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.elhady.ijobs.databinding.FavouriteFragmentBinding
import com.elhady.ijobs.ui.adapter.IjobAdapter
import com.elhady.ijobs.ui.adapter.JobClick
import com.elhady.ijobs.ui.view.home.ListJobsFragmentDirections
import org.koin.android.viewmodel.ext.android.viewModel

class FavouriteFragment : Fragment() {

    private lateinit var binding: FavouriteFragmentBinding
    private val viewModel: FavouriteViewModel by viewModel()
    private var adapter: IjobAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FavouriteFragmentBinding.inflate(inflater)

        setupAdapter()
        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.favoriteJobList.observe(viewLifecycleOwner, Observer {
            adapter?.submitList(it)
        })
    }

    private fun setupAdapter() {
        adapter = IjobAdapter(JobClick { it, version ->
            when(version){
                0 -> findNavController().navigate(ListJobsFragmentDirections.actionListJobsFragmentToDetailsJobsFragment(it))
                1 -> viewModel.toggleFavorites(it)
            }
        })

        binding.favRecyclerView.adapter = adapter
        postponeEnterTransition()
        binding.favRecyclerView.viewTreeObserver.addOnPreDrawListener {
            startPostponedEnterTransition()
            true
        }
    }

}