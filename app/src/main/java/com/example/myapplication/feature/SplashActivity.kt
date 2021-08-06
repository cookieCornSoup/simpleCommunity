package com.example.myapplication.feature

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.feature.singup.EmailCheckActivity
import com.example.myapplication.feature.singup.SigninActivity
import com.example.myapplication.model.UsersRetrieveResponse
import com.example.myapplication.repository.SharedPref
import com.example.myapplication.retrofit.Client
import retrofit2.Call
import retrofit2.Response

class SplashActivity : AppCompatActivity() {

    val PREFERENCE = "com.android.signin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPref.openSharedPrep(this)
        val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)

        if (SharedPref.readAutoSigninSession() == true) {

            Client.retrofitService.usersRetrieve(
                SharedPref.readUserEmail().toString()
            ).enqueue(object : retrofit2.Callback<UsersRetrieveResponse> {
                @SuppressLint("ShowToast")
                override fun onResponse(
                    call: Call<UsersRetrieveResponse>?,
                    response: Response<UsersRetrieveResponse>?
                ) {
                    when (response!!.code()) {
                        200 -> {
                            //회원가입만 시도 후 이탈시 이메일 처리 필요.
                            if (response.body()?.isVerified == false) {
                                val intent =
                                    Intent(this@SplashActivity, EmailCheckActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Intent(this@SplashActivity, MainActivity::class.java)
                                startActivity(intent)
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
                                "로그인 실패 : 서버 오류",
                                Toast.LENGTH_LONG
                            ).show()

                            val intent =
                                Intent(this@SplashActivity, SigninActivity::class.java)
                            startActivity(intent)
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