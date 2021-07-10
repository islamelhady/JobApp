package com.elhady.ijobs.ui.view.apply

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.elhady.ijobs.databinding.FragmentApplyBinding


/**
 * Created by islam elhady on 10-Jul-21.
 */
class ApplyFragment : Fragment() {

    private lateinit var binding: FragmentApplyBinding
    private val args: ApplyFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentApplyBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
//            urlJob = arguments?.getString("URL")
            urlJob = args.urljob
        }
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        binding.applyJob.apply {
//            transitionName = args.urlJob
//        }
//    }

}