package com.elhady.ijobs.ui.view.splash

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.elhady.ijobs.R
import com.elhady.ijobs.databinding.FragmentSplashBinding
import com.elhady.ijobs.ui.base.BaseFragment
import kotlinx.coroutines.*

/**
 * Created by islam elhady on 22-Mar-21.
 */
class SplashFragment :
    BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            delay(1000L)
            findNavController().navigate(
                R.id.action_splashFragment_to_listJobsFragment
            )
        }
    }
}