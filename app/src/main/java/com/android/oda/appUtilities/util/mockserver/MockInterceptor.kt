package com.android.oda.appUtilities.util.mockserver

import android.util.Log
import com.android.oda.BuildConfig
import com.android.oda.data.shopping.ProductsApiMock
import com.android.oda.data.shopping.ProductsApiUrls
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException

class MockInterceptor() : Interceptor {
    companion object {
        private const val TAG = "MockInterceptor"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response? = null
        var fakeResponse = ""
        if (BuildConfig.DEBUG) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val requestUrl = chain.request().url.toString()
            fakeResponse =
                when {
                    requestUrl.contains(ProductsApiUrls.rootPath) -> ProductsApiMock.getMockJsonForUrl(
                        requestUrl
                    )
                    else -> ""
                }

            Log.d(TAG, "FAKE REQUEST " + chain.request().url)
            Log.d(TAG, "FAKE response $fakeResponse")
            response = Response.Builder()
                .code(200)
                .message(fakeResponse)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(
                    fakeResponse.toByteArray()
                        .toResponseBody("application/json".toMediaTypeOrNull())
                )
                .addHeader("content-type", "application/json")
                .build()
        } else {
            response = chain.proceed(chain.request())
        }
        return response
    }
}

