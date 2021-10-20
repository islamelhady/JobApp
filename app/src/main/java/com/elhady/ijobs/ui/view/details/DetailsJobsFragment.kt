package com.elhady.ijobs.ui.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.elhady.ijobs.ui.view.MainActivity
import com.elhady.ijobs.R
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.FragmentDetailsJobsBinding
import com.elhady.ijobs.ui.base.BaseFragment

/**
 * Created by islam elhady on 22-Mar-21.
 */
class DetailsJobsFragment :
    BaseFragment<FragmentDetailsJobsBinding>(R.layout.fragment_details_jobs) {

    private val args: DetailsJobsFragmentArgs by navArgs()
    private var jobVal: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.apply {
            ijobs = jobVal
            detailsJobs = this@DetailsJobsFragment
        }
    }

    private fun setupToolbar() {
        if (requireActivity() is MainActivity) {
            (activity as AppCompatActivity?)!!.setSupportActionBar(binder.toolbar)
            (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity?)!!.supportActionBar!!.setTitle(jobVal?.title)
        }
    }

    /**
     * Navigate to the apply screen to apply job .
     */
    fun goToApplyJob() {

        val bundle = bundleOf("URL" to args.job.url, "TITLE" to args.job.title)
        findNavController().navigate(R.id.action_detailsJobsFragment_to_applyFragment, bundle)
    }

    // clear views references to fix memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        binder.unbind()
    }
}