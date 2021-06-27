package com.elhady.ijobs.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import com.elhady.ijobs.data.model.Jobs
import com.elhady.ijobs.data.repository.MainRepository


/**
 * Created by islam elhady on 23-Mar-21.
 */
class MainViewModel (
    private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

    var pokemonListLiveData: LiveData<List<Jobs>> = launchOnViewModelScope {
        this.mainRepository.loadPokemonList {}
    }


    companion object {
        private const val JobsKey = "Jobs"
        fun createArguments(jobs: Jobs): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(JobsKey, jobs)
            return bundle
        }
    }
}

