package com.example.simplecommunity.signup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.model.signup.EmailCheckDTO
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.signup.repository.EmailCheckRepository

class EmailCheckViewModel (application: Application) : AndroidViewModel(application) {

    private val repository = EmailCheckRepository()
    private val sharedpref = SharedPref(application)

    fun emailCheck(emailCheckDTO: EmailCheckDTO, callback: BaseResponse<String>){
        repository.emailCheck(emailCheckDTO, callback, sharedpref)
    }


}