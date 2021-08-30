package com.example.simplecommunity.signup.repository

import android.annotation.SuppressLint
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.model.signup.SignupDTO
import com.example.simplecommunity.model.signup.UsersActivateResponse
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Response

class SignupRepository {

    fun signup(
        signupDTO: SignupDTO,
        callback: BaseResponse<UsersActivateResponse>,
        sharedPref: SharedPref
    ) {
        Client.retrofitService.signUp(
            signupDTO.email,
            signupDTO.nikename,
            signupDTO.password
        ).enqueue(object : retrofit2.Callback<UsersActivateResponse> {
            @SuppressLint("ShowToast")
            override fun onResponse(
                call: Call<UsersActivateResponse>?,
                response: Response<UsersActivateResponse>?
            ) {
                val body = response?.body()
                if (response!!.isSuccessful && null != body) {
                    when (response!!.code()) {
                        200 -> {
                            sharedPref.email = response.body()?.email.toString()
                            callback.onSuccess(body)
                        }
                        405 -> {
                            callback.onFail("허용되지 않은 메소드로 정의되었습니다.")
                        }
                        500 -> {
                            callback.onFail("로그인 실패 : 서버 오류")
                        }
                        401 ->{
                            callback.onFail("인증이 만료되었습니다.", true)
                        }
                    }
                }
                callback.onLoaded()
            }

            override fun onFailure(call: Call<UsersActivateResponse>?, t: Throwable?) {
                callback.onError(t!!)
                callback.onLoaded()
            }
        })

    }
}
