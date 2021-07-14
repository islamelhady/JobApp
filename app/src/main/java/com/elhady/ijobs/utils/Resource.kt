package com.elhady.ijobs.utils

/**
 * Created by islam elhady on 11-Jul-21.
 */
sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Failed<T>(val message: String) : Resource<T>()
}