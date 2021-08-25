package com.example.simplecommunity.signin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.model.SigninCheckOkResponse
import com.example.simplecommunity.model.SigninDTO
import com.example.simplecommunity.signin.repository.SigninRepository

class SigninViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SigninRepository(application)

    fun signIn(signinDTO: SigninDTO, callback: BaseResponse<SigninCheckOkResponse>) {
        repository.signIn(signinDTO, callback)
    }

}