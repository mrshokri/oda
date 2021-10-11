package com.android.oda.appUtilities.util.serviceAuthentication

interface AuthRepository {
    fun getAccessToken(): String
    fun getRefreshToken(): String
    fun saveAccessToken(accessToken: String)
    fun saveRefreshToken(refreshToken: String)
}

class AuthRepositoryImpl(private val tokenPrefManager: AuthTokenPrefManager) :
    AuthRepository {

    override fun getAccessToken(): String {
        return tokenPrefManager.getAccessToken()
    }

    override fun getRefreshToken(): String {
        return tokenPrefManager.getRefreshToken()
    }

    override fun saveAccessToken(accessToken: String) {
        tokenPrefManager.saveAccessToken(accessToken)
    }

    override fun saveRefreshToken(refreshToken: String) {
        return tokenPrefManager.saveRefreshToken(refreshToken)
    }

}