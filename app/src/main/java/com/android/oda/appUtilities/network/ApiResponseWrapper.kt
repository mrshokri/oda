package com.android.oda.appUtilities.network

import androidx.annotation.Keep

sealed class ApiResponseWrapper<out T> {
    class Success<out T>(val value: T) : ApiResponseWrapper<T>()
    class Failure(val apiError: ApiError) : ApiResponseWrapper<Nothing>()
}

sealed class ApiError : Exception() {
    object UnKnownFailure : ApiError()
    object NetworkFailure : ApiError()
    object JsonParseFailure : ApiError()
    object ServerFailure : ApiError()
    data class ClientFailure(val internalError: InternalError) : ApiError()
}

@Keep
data class InternalError(
    val data: Details
){
    fun getCode(): Int{
        return data.code
    }

    fun getMessage(): String{
        return data.message
    }
}

@Keep
data class Details(val code: Int, val message: String)
