package com.elhady.ijobs.data.repository

import androidx.annotation.MainThread
import com.elhady.ijobs.utils.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * Created by islam elhady on 27-Jun-21.
 */
abstract class NetworkBoundRepository<T> {

    fun asFlow() = flow<State<T>> {
        emit(State.loading())

        try {
            val apiResponse = fetchFromRemote()

            val response = apiResponse.body()

            if (apiResponse.isSuccessful && response != null)
                emit(State.success(response))
            else
                emit(State.error(apiResponse.message()))

        } catch (e: Exception) {
            emit(State.error(e.message.toString()))
        }
    }

    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<T>
}