package com.kaleniuk2.data.remote.util

import com.kaleniuk2.domain.wrapper.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
    return withContext(Dispatchers.IO) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (exception: Exception) {
            ResultWrapper.Error(exception)
        }
    }
}

