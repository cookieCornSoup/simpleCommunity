package com.example.simplecommunity.repository

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SharedPref {

    private const val PREF_AUTOLOGIN = "auto_login"
    private const val PREF_TOKEN = "access_token"
    private const val PREF_REFRESH_TOKEN = "refresh_token"
    private const val PREF_EMAIL = "email"


    private const val PREF_NAME  = "com.android.signin"
    private const val PREF_MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PREF_MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor)->Unit) {
        val editor = edit()
        operation(edit())
        edit().apply()
    }

    var access_token: String
        get() = sharedPreferences.getString(PREF_TOKEN, "").toString()
        set(value) = sharedPreferences.edit {
            it.putString(PREF_TOKEN, value)
        }

    var refresh_token: String
        get() = sharedPreferences.getString(PREF_REFRESH_TOKEN, "").toString()
        set(value) = sharedPreferences.edit {
            it.putString(PREF_REFRESH_TOKEN, value)
        }

    var autoLogin: Boolean
        get() = sharedPreferences.getBoolean(PREF_AUTOLOGIN, false)
        set(value) = sharedPreferences.edit{
            it.putBoolean(PREF_AUTOLOGIN, value)
        }

    var email: String
        get() = sharedPreferences.getString(PREF_EMAIL, "").toString()
        set(value) = sharedPreferences.edit{
            it.putString(PREF_EMAIL, value)
        }
}