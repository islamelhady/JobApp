package com.elhady.ijobs.ui.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elhady.ijobs.R
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.databinding.FragmentDetailsJobsBinding

/**
 * Created by islam elhady on 22-Mar-21.
 */
class DetailsJobsFragment : Fragment() {


    private lateinit var binding: FragmentDetailsJobsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsJobsBinding.inflate(inflater, container, false)
        return binding.apply {
            jobs = (requireArguments().get(getString(R.string.jobs_key))) as Jobs
        }.root
    }

}