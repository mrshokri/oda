package com.android.oda.appUtilities.util.serviceAuthentication

import android.content.SharedPreferences
import com.android.oda.appUtilities.extentions.edit
import com.android.oda.appUtilities.extentions.getPref
import com.android.oda.appUtilities.util.TokenType

interface AuthTokenPrefManager {
    fun getAccessToken(): String
    fun getRefreshToken(): String
    fun saveAccessToken(accessToken: String)
    fun saveRefreshToken(refreshToken: String)
}

class AuthTokenPrefManagerImp(private val prefs: SharedPreferences) : AuthTokenPrefManager {

    override fun getAccessToken(): String {
        return prefs.getPref(TokenType.ACCESS) ?: ""
    }

    override fun getRefreshToken(): String {
        return prefs.getPref(TokenType.REFRESH) ?: ""
    }

    override fun saveAccessToken(accessToken: String) {
        prefs.edit { it.putString(TokenType.ACCESS, accessToken) }
    }

    override fun saveRefreshToken(refreshToken: String) {
        prefs.edit { it.putString(TokenType.REFRESH, refreshToken) }
    }
}