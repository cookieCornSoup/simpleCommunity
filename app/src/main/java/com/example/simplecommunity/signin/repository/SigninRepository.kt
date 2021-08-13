package com.example.simplecommunity.signin.repository

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.base.RepoRepository
import com.example.simplecommunity.feature.MainActivity
import com.example.simplecommunity.model.SigninCheckOkResponse
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SigninRepository : RepoRepository {


    override fun signIn(
        email: String,
        password: String,
        callback: BaseResponse<SigninCheckOkResponse>
    ) {
        Client.retrofitService.signIn(
            email,
            password
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