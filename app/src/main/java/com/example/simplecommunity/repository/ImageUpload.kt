package com.example.simplecommunity.repository

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import com.example.simplecommunity.feature.MainActivity
import com.example.simplecommunity.model.SigninCheckOkResponse
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageUpload {

//    fun getImageUri() {
//        Client.retrofitService.signIn(
//
//        ).enqueue(object : Callback<SigninCheckOkResponse> {
//            @SuppressLint("ShowToast")
//            override fun onResponse(
//                call: Call<SigninCheckOkResponse>?,
//                response: Response<SigninCheckOkResponse>?
//            ) {
//                when (response!!.code()) {
//                    200 -> {
//
//                    }
//                    405 -> Toast.makeText(
//                        this@SigninActivity,
//                        "로그인 실패 : 아이디나 비번이 올바르지 않습니다",
//                        Toast.LENGTH_LONG
//                    ).show()
//                    500 -> Toast.makeText(
//                        this@SigninActivity,
//                        "로그인 실패 : 서버 오류",
//                        Toast.LENGTH_LONG
//                    ).show()
//                    401 -> Toast.makeText(
//                        this@SigninActivity,
//                        "잘못된 인증자격(리프레시 토큰으로 바꾸기)",
//                        Toast.LENGTH_LONG
//                    ).show()
//                    403 -> Toast.makeText(
//                        this@SigninActivity,
//                        "403 forbidden",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            }
//
//            override fun onFailure(call: Call<SigninCheckOkResponse>?, t: Throwable?) {
//
//            }
//        })
//
//    }
}