package com.example.simplecommunity.signup.repository

import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.model.signup.EmailCheckDTO
import com.example.simplecommunity.model.signup.EmailCheckResponse
import com.example.simplecommunity.model.signup.UsersActivateResponse
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client

class EmailCheckRepository {

    fun emailCheck(
        emailCheckDTO: EmailCheckDTO,
        callback: BaseResponse<EmailCheckResponse>,
        sharedPref: SharedPref
    ){
        Client.retrofitService.
    }

}