package com.example.simplecommunity.signup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.signin.repository.SigninRepository
import com.example.simplecommunity.signup.repository.SignupRepository

class SignupViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SignupRepository(application)
    private val sharedpref = SharedPref(application)

    fun Signup{


    }

}