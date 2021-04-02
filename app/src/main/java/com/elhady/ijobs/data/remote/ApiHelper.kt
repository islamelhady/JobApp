package com.elhady.ijobs.data.remote

import com.elhady.ijobs.utils.Resource
import retrofit2.Response
import timber.log.Timber

/**
 * Created by islam elhady on 22-Mar-21.
 */
abstract class ApiHelper {
//    suspend fun fetchJobsList(): Response<List<Jobs>>

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.d(message)
        return Resource.error("Network call has failed for a following reason: $message")
    }

}