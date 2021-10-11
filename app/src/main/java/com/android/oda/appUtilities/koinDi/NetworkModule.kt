package com.android.oda.appUtilities.koinDi

import com.android.oda.BuildConfig
import com.android.oda.appUtilities.util.*
import com.android.oda.appUtilities.util.mockserver.MockInterceptor
import com.android.oda.appUtilities.util.serviceAuthentication.AuthRepositoryImpl
import com.android.oda.appUtilities.util.serviceAuthentication.AuthTokenPrefManagerImp
import com.android.oda.appUtilities.util.serviceAuthentication.AuthenticateInterceptor
import com.android.oda.appUtilities.util.serviceAuthentication.QueryTokenInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { provideGson() }

    // common headers for requests
    single(named(Headers.EXTRA_HEADERS)) {
        listOf<Pair<String, String>>(
            //(Headers.PLATFORM to get(named(Headers.PLATFORM))),
        )
    }

    //mock server client
    single(named(HttpClientType.MOCK)) { provideMockOkHttpClient() }
    single(named(RetrofitType.MOCK)) {
        provideRetrofitModule(
            get(named(HttpClientType.MOCK)),
            get(),
            get(named(App.BASE_URL))
        )
    }

    // anonymous client
    single(named(HttpClientType.ANONYMOUS)) { provideDefaultOkHttpClient() }
    single(named(RetrofitType.ANONYMOUS)) {
        provideRetrofitModule(
            get(named(HttpClientType.ANONYMOUS)),
            get(),
            get(named(App.BASE_URL))
        )
    }

    //authenticated client
    single(named(Authentication.PREFERENCE)) { AuthTokenPrefManagerImp(get(named(App.PREFERENCES))) }
    single(named(Authentication.REPOSITORY)) {
        AuthRepositoryImpl(
            get(
                named(Authentication.PREFERENCE)
            )
        )
    }
    single(named(InterceptorType.AUTHENTICATED)) {
        AuthenticateInterceptor(
            get(named(Headers.EXTRA_HEADERS)),
            Headers.AUTH_TOKEN,
            get(named(Authentication.REPOSITORY))
        )
    }
    single(named(HttpClientType.AUTHENTICATED)) {
        provideAuthenticatedOkHttpClient(
            get(named(InterceptorType.AUTHENTICATED)),
            get(named(App.NETWORK_TIMEOUT))
        )
    }
    single(named(RetrofitType.AUTHENTICATED)) {
        provideRetrofitModule(
            get(named(HttpClientType.AUTHENTICATED)),
            get(),
            get(named(App.BASE_URL))
        )
    }
}

inline fun <reified T> createApi(retrofit: Retrofit): T = retrofit.create(T::class.java)

fun provideDefaultOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    if ((BuildConfig.DEBUG)) {
        builder.addInterceptor(OkHttpProfilerInterceptor())
    }
    return builder.build()
}

fun provideMockOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(OkHttpProfilerInterceptor())
        .addInterceptor(MockInterceptor())
        .build()
}

fun provideAuthenticatedOkHttpClient(
    authenticateInterceptor: Interceptor,
    timeout: Long
): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(authenticateInterceptor)
        .readTimeout(timeout, TimeUnit.MILLISECONDS)
        .writeTimeout(timeout, TimeUnit.MILLISECONDS)
        .connectTimeout(timeout, TimeUnit.MILLISECONDS)
    if (BuildConfig.DEBUG) {
        builder.addInterceptor(OkHttpProfilerInterceptor())
    }
    return builder.build()
}

fun provideRetrofitModule(
    client: OkHttpClient,
    gson: Gson,
    baseUrl: String
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder().serializeNulls()
    return gsonBuilder.create()
}

