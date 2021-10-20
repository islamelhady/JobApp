package com.elhady.ijobs.ui.view.apply

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.elhady.ijobs.R
import com.elhady.ijobs.ui.view.MainActivity
import com.elhady.ijobs.databinding.FragmentApplyBinding
import com.elhady.ijobs.ui.base.BaseFragment


/**
 * Created by islam elhady on 10-Jul-21.
 */
class ApplyFragment :
    BaseFragment<FragmentApplyBinding>(R.layout.fragment_apply) {

    private val args: ApplyFragmentArgs by navArgs()
    private var title: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.apply{
            urlJob = arguments?.getString("URL")
        }
    }

    private fun setupToolbar(){
        if(requireActivity() is MainActivity){
            (activity as AppCompatActivity?)!!.setSupportActionBar(binder.toolbar)
            (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity?)!!.supportActionBar!!.setTitle(title)
        }
    }

}