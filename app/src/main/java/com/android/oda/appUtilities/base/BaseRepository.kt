package com.android.oda.appUtilities.base

import com.android.oda.appUtilities.network.ApiResponseWrapper
import com.android.oda.appUtilities.network.InternalError
import com.android.oda.appUtilities.network.Details
import com.android.oda.appUtilities.network.ApiError
import com.google.gson.JsonParseException
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException


interface BaseRepository {
    suspend fun <T> call(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
    ): ApiResponseWrapper<T>
}

open class BaseRepositoryDelegation : BaseRepository {
    override suspend fun <T> call(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
    ): ApiResponseWrapper<T> {
        return withContext(dispatcher) {
            try {
                ApiResponseWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ApiResponseWrapper.Failure(ApiError.NetworkFailure)
                    is JsonParseException -> ApiResponseWrapper.Failure(ApiError.JsonParseFailure)
                    is HttpException -> {
                        when (throwable.code()) {
                            // Client Errors
                            in 400..500 -> ApiResponseWrapper.Failure(
                                ApiError.ClientFailure(
                                    convertErrorBody(throwable)
                                )
                            )
                            // Server Errors
                            in 500..600 -> ApiResponseWrapper.Failure(ApiError.ServerFailure)
                            else -> ApiResponseWrapper.Failure(ApiError.UnKnownFailure)
                        }
                    }
                    else -> ApiResponseWrapper.Failure(ApiError.UnKnownFailure)
                }
            }
        }
    }

    private fun convertErrorBody(throwable: HttpException): InternalError {
        return try {
            throwable.response()?.errorBody()?.source()?.let {
                val moshiAdapter = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                    .adapter(InternalError::class.java)
                moshiAdapter.fromJson(it)
            } ?: InternalError(
                Details(
                    -1,
                    throwable.message ?: "Can't Parse Exception, Debug BaseRepository:75"
                )
            )
        } catch (exception: Exception) {
            InternalError(
                Details(
                    -1,
                    throwable.message ?: "Can't Parse Exception, Debug BaseRepository:75"
                )
            )
        }
    }
}