package com.elhady.ijobs.ui.view.apply

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.elhady.ijobs.ui.view.MainActivity
import com.elhady.ijobs.databinding.FragmentApplyBinding


/**
 * Created by islam elhady on 10-Jul-21.
 */
class ApplyFragment : Fragment() {

    private lateinit var binding: FragmentApplyBinding
    private val args: ApplyFragmentArgs by navArgs()
    private var title: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentApplyBinding.inflate(inflater)
        // recieved argums
        title = arguments?.getString("TITLE")
        setupToolbar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
            urlJob = arguments?.getString("URL")
        }
    }

    private fun setupToolbar(){
        if(requireActivity() is MainActivity){
            (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar)
            (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity?)!!.supportActionBar!!.setTitle(title)
        }
    }

}