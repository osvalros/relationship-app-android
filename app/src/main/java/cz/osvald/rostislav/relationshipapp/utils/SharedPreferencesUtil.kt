package cz.osvald.rostislav.relationshipapp.utils

import android.content.Context
import android.content.SharedPreferences
import cz.osvald.rostislav.relationshipapp.R
import cz.osvald.rostislav.relationshipapp.RelationshipAppApplication

class SharedPreferencesUtil {
    private val sharedPreferences: SharedPreferences by lazy {
        val context = RelationshipAppApplication.appContext
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }

    fun saveAuthToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun getAuthToken(): String? {
        return sharedPreferences.getString(USER_TOKEN, null)
    }
}