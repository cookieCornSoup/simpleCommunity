package com.example.myapplication.feature

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.feature.singup.EmailCheckActivity
import com.example.myapplication.feature.singup.SigninActivity
import com.example.myapplication.model.SigninCheckOkResponse
import com.example.myapplication.model.UsersRetrieveResponse
import com.example.myapplication.repository.SharedPref
import com.example.myapplication.retrofit.Client
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

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
                        401 -> {
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
                        500 -> Toast.makeText(
                            this@SplashActivity,
                            "로그인 실패 : 서버 오류",
                            Toast.LENGTH_LONG
                        ).show()
                        401 -> Toast.makeText(
                            this@SplashActivity,
                            "잘못된 인증자격(리프레시 토큰으로 바꾸기)",
                            Toast.LENGTH_LONG
                        )
                    }
                }
                override fun onFailure(call: Call<UsersRetrieveResponse>?, t: Throwable?) {
                }
            })
        }
        //자동로그인이 꺼져있을때
        Intent(this@SplashActivity, SigninActivity::class.java)
        startActivity(intent)
        finish()
    }
}