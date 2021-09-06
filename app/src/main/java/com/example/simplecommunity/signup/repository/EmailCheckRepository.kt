package com.example.simplecommunity.signup.repository

import android.annotation.SuppressLint
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.model.signup.EmailCheckDTO
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Response

class EmailCheckRepository {

    fun emailCheck(
        emailCheckDTO: EmailCheckDTO,
        callback: BaseResponse<String>,
        sharedPref: SharedPref
    ){
        Client.retrofitService.usersActivate(
            emailCheckDTO.email,
            emailCheckDTO.authNum
        ).enqueue(object : retrofit2.Callback<Void>{
            @SuppressLint("ShowToast")
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                val body = response.body()
                if (response.isSuccessful && null != body) {
                    when (response.code()) {
                        204 -> {
                            callback.onSuccess("인증이 완료되었습니다.")
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

            override fun onFailure(call: Call<Void>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

}