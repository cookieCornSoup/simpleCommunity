package com.example.simplecommunity.repository

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SharedPref {
    val LOGIN_SESSION = "com.android.signin"

    private var sharedPref: SharedPreferences? = null

    fun openSharedPrep(context: Context) {
        this.sharedPref = context.getSharedPreferences(LOGIN_SESSION, Context.MODE_PRIVATE)
    }
    fun writeLoginSession(access_token: String, refresh_token: String) {
        if(this.sharedPref == null) {
            Log.e("sharedpref", "Plz start openSahredPrep() !")
        } else {
            sharedPref?.edit()?.putString("access_token", access_token)?.apply()
            sharedPref?.edit()?.putString("refresh_token", refresh_token)?.apply()
        }
    }

    fun readAccessSession() : String? {
        return if(this.sharedPref == null) {
            Log.e("sharedpref", "Plz start openSahredPrep() !")
            null
        } else sharedPref?.getString("access_token", null)
    }

    fun readRefreshSession() : String? {
        return if(this.sharedPref == null) {
            Log.e("sharedpref", "Plz start openSahredPrep() !")
            null
        } else sharedPref?.getString("refresh_token", null)
    }

    fun readAutoSigninSession() : Boolean?{
        return if(this.sharedPref == null) {
            Log.e("sharedpref", "Plz start openSahredPrep() !")
            null
        } else sharedPref?.getBoolean("auto_login", false)
    }

    fun readUserEmail() : String?{
        return if(this.sharedPref == null) {
            Log.e("sharedpref", "Plz start openSahredPrep() !")
            null
        } else sharedPref?.getString("email", null)
    }
}