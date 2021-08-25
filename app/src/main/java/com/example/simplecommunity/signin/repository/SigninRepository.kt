package com.example.simplecommunity.signin.repository

import android.annotation.SuppressLint
import android.app.Application
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.base.RepoRepository
import com.example.simplecommunity.model.SigninCheckOkResponse
import com.example.simplecommunity.model.SigninDTO
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigninRepository(application: Application) : RepoRepository {


    override fun signIn(
        signinDTO: SigninDTO,
        callback: BaseResponse<SigninCheckOkResponse>
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
                            SharedPref.access_token = response.body()?.access_token.toString()
                            SharedPref.refresh_token = response.body()?.refresh_token.toString()

                            SharedPref.email = signinDTO.email

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