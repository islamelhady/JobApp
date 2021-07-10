package com.elhady.ijobs.ui.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.elhady.ijobs.R
import com.elhady.ijobs.data.model.Job
import com.elhady.ijobs.databinding.FragmentDetailsJobsBinding

/**
 * Created by islam elhady on 22-Mar-21.
 */
class DetailsJobsFragment : Fragment() {


    private lateinit var binding: FragmentDetailsJobsBinding
    private val args: DetailsJobsFragmentArgs by navArgs()
    private var jobVal: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsJobsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            ijobs = args.job
            detailsJobs = this@DetailsJobsFragment
        }
    }

    /**
     * Navigate to the apply screen to apply job .
     */
    fun goToApplyJob(){
        findNavController().navigate(R.id.action_detailsJobsFragment_to_applyFragment)
    }

    // clear views references to fix memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}