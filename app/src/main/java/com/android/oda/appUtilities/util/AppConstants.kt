package com.android.oda.appUtilities.util

class RetrofitType {
    companion object {
        const val ANONYMOUS = "RETROFIT_ANONYMOUS"
        const val AUTHENTICATED = "RETROFIT_AUTHENTICATED"
        const val MOCK = "RETROFIT_MOCK"
    }
}

class HttpClientType {
    companion object {
        const val ANONYMOUS = "HTTP_CLIENT_ANONYMOUS"
        const val AUTHENTICATED = "HTTP_CLIENT_AUTHENTICATED"
        const val MOCK = "HTTP_CLIENT_MOCK"
    }
}

class InterceptorType {
    companion object {
        const val AUTHENTICATED = "AUTHENTICATED"
    }
}

class Headers {
    companion object {
        // headers name that provided by app module
        const val EXTRA_HEADERS = "APP_EXTRA_HEADERS"
        const val AUTH_TOKEN = "Authorization"
    }
}

class App {
    companion object {
        const val RESOURCES = "RESOURCES"
        const val PREFERENCES = "PREFERENCES"
        const val PREFERENCES_NAME = "PREFERENCES_NAME"
        const val BASE_URL = "BASE_URL"
        const val NETWORK_TIMEOUT = "NETWORK_TIMEOUT"
    }
}

class TokenType {
    companion object {
        const val ACCESS = "access_token"
        const val REFRESH = "refresh_token"
    }
}

class Authentication {
    companion object {
        const val PREFERENCE = "AUTH_PREFERENCE"
        const val REPOSITORY = "AUTH_REPOSITORY"
    }
}

