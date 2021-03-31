package com.elhady.ijobs.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

fun <T, A> performGetOperation(databaseQuery: () -> LiveData<T>,
                               networkCall: suspend () -> Resource<A>,
                               saveCallResult: suspend (A) -> Unit): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())
//        val source = databaseQuery.invoke().map { Resource.success(it) }
        emitSource(databaseQuery.invoke().map { Resource.success(it) })

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == Status.ERROR) {
            emit(Resource.error(responseStatus.message!!))
            emitSource(databaseQuery.invoke().map { Resource.success(it) })
        }
    }

