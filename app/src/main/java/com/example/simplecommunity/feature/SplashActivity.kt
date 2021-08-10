package com.example.simplecommunity.feature

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecommunity.feature.signup.EmailCheckActivity
import com.example.simplecommunity.feature.signup.SigninActivity
import com.example.simplecommunity.model.UsersRetrieveResponse
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {

    val PREFERENCE = "com.android.signin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPref.openSharedPrep(this)
        val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)

        if (SharedPref.readAutoSigninSession() == true && SharedPref.readAccessSession() != null) {
            Client.retrofitService.usersRetrieve(
                "Bearer " + SharedPref.readAccessSession().toString(),
                SharedPref.readUserEmail().toString()
            ).enqueue(object : Callback<UsersRetrieveResponse> {
                @SuppressLint("ShowToast")
                override fun onResponse(
                    call: Call<UsersRetrieveResponse>?,
                    response: Response<UsersRetrieveResponse>?,
                ) {
                    when (response!!.code()) {
                        200 -> {
                            //회원가입만 시도 후 이탈시 이메일 처리 필요.
                            val userinfo = response.body()
                            System.out.println(userinfo?.is_verified)

                            if (response.body()?.is_verified == false) {
                                startActivity(
                                    Intent(
                                        this@SplashActivity,
                                        EmailCheckActivity::class.java
                                    )
                                )
                                finish()
                            } else {
                                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                                finish()
                            }
                        }
                        400 -> Toast.makeText(
                            this@SplashActivity,
                            "잘못된 요청입니다.",
                            Toast.LENGTH_LONG
                        )
                        401 -> {
                            //토큰 만료.
                            Toast.makeText(
                                this@SplashActivity,
                                "로그인 실패 재로그인 부탁드립니다.",
                                Toast.LENGTH_LONG
                            ).show()

                            startActivity(Intent(this@SplashActivity, SigninActivity::class.java))
                            finish()
                        }
                        403 -> Toast.makeText(
                            this@SplashActivity,
                            "잘못된 인증입니다.",
                            Toast.LENGTH_LONG
                        )
                        404 -> Toast.makeText(
                            this@SplashActivity,
                            "잘못된 리소스 요청입니다.",
                            Toast.LENGTH_LONG
                        )
                        405 -> Toast.makeText(
                            this@SplashActivity,
                            "Method Not Allowed",
                            Toast.LENGTH_LONG
                        )
                        500 -> Toast.makeText(
                            this@SplashActivity,
                            "로그인 실패 : 서버 오류",
                            Toast.LENGTH_LONG
                        ).show()

                    }

                }


                override fun onFailure(call: Call<UsersRetrieveResponse>?, t: Throwable?) {
                }
            })
        } else {
            //자동로그인이 꺼져있을때
            startActivity(Intent(this@SplashActivity, SigninActivity::class.java))
            finish()
        }
    }
}