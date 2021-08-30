package com.example.simplecommunity.signup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.model.signin.SigninCheckOkResponse
import com.example.simplecommunity.model.signin.SigninDTO
import com.example.simplecommunity.model.signup.SignupDTO
import com.example.simplecommunity.model.signup.UsersActivateResponse
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.signin.repository.SigninRepository
import com.example.simplecommunity.signup.repository.SignupRepository

class SignupViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SignupRepository()
    private val sharedpref = SharedPref(application)

    fun signup(signupDTO: SignupDTO, callback: BaseResponse<UsersActivateResponse>){
        repository.signup(signupDTO, callback, sharedpref)
    }


}