package com.example.simplecommunity.signin.repository

import android.annotation.SuppressLint
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.model.signin.SigninCheckOkResponse
import com.example.simplecommunity.model.signin.SigninDTO
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigninRepository {


    fun signIn(
        signinDTO: SigninDTO,
        callback: BaseResponse<SigninCheckOkResponse>,
        sharedPref: SharedPref
    ) {
        Client.retrofitService.signIn(
            signinDTO.email,
            signinDTO.password
        ).enqueue(object : Callback<SigninCheckOkResponse> {
            @SuppressLint("ShowToast")
            override fun onResponse(
                call: Call<SigninCheckOkResponse>?,
                response: Response<SigninCheckOkResponse>?
            ) {
                val body = response?.body()
                if (response!!.isSuccessful && null != body) {
                    when (response.code()) {
                        200 -> {
                            sharedPref.access_token = response.body()?.access_token.toString()
                            sharedPref.refresh_token = response.body()?.refresh_token.toString()

                            sharedPref.email = signinDTO.email

                            callback.onSuccess(body)
                        }

                        401 -> {
                            callback.onFail(response.message())

                        }

                    }
                }
                callback.onLoaded()
            }

            override fun onFailure(call: Call<SigninCheckOkResponse>?, t: Throwable?) {
                callback.onError(t!!)
                callback.onLoaded()
            }
        })
    }
}