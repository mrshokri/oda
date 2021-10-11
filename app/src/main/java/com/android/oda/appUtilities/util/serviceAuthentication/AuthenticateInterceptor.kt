package com.android.oda.appUtilities.util.serviceAuthentication

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticateInterceptor(
    private val extraHeaders: List<Pair<String, String>>,
    private val authHeader: String,
    private val oauthRepository: AuthRepository,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request
        val builder = chain.request().newBuilder()
        extraHeaders.forEach {
            builder.addHeader(it.first, it.second)
        }
        builder.addHeader(authHeader, "Bearer ${oauthRepository.getAccessToken()}")
        request = builder.build()
        return chain.proceed(request)
    }


}

