package com.example.simplecommunity.feature.signup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.simplecommunity.base.BaseActivity

import com.example.simplecommunity.databinding.ActivitySigninBinding
import com.example.simplecommunity.feature.MainActivity
import com.example.simplecommunity.model.SigninCheckOkResponse
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SigninActivity : BaseActivity<ActivitySigninBinding>({ ActivitySigninBinding.inflate(it) }) {

    val PREFERENCE = "com.android.signin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPref.openSharedPrep(this@SigninActivity)
        val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)
        val editor = pref.edit()

        binding.autoSignInCheckbox.setOnClickListener {
            if (binding.autoSignInCheckbox.isChecked) {
                editor.putBoolean(
                    "auto_login",
                    true
                )
                editor.apply()
            } else {
                editor.putBoolean(
                    "auto_login",
                    false
                )
                editor.apply()
            }
        }

        binding.signInBtn.setOnClickListener {
            Client.retrofitService.signIn(
                binding.signInIdEditText.text.toString(),
                binding.signInPasswordEditText.text.toString()
            ).enqueue(object : Callback<SigninCheckOkResponse> {
                @SuppressLint("ShowToast")
                override fun onResponse(
                    call: Call<SigninCheckOkResponse>?,
                    response: Response<SigninCheckOkResponse>?
                ) {
                    when (response!!.code()) {
                        200 -> {
                            editor.putString(
                                "access_token",
                                response.body()?.access_token
                            )
                            editor.putString(
                                "refresh_token",
                                response.body()?.refresh_token
                            )
                            editor.putString(
                                "email",
                                binding.signInIdEditText.text.toString()
                            )
                            editor.apply()
                            finish()
                            startActivity(Intent(this@SigninActivity, MainActivity::class.java))
                        }
                        405 -> Toast.makeText(
                            this@SigninActivity,
                            "로그인 실패 : 아이디나 비번이 올바르지 않습니다",
                            Toast.LENGTH_LONG
                        ).show()
                        500 -> Toast.makeText(
                            this@SigninActivity,
                            "로그인 실패 : 서버 오류",
                            Toast.LENGTH_LONG
                        ).show()
                        401 -> Toast.makeText(
                            this@SigninActivity,
                            "잘못된 인증자격(리프레시 토큰으로 바꾸기)",
                            Toast.LENGTH_LONG
                        ).show()
                        403 -> Toast.makeText(
                            this@SigninActivity,
                            "403 forbidden",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<SigninCheckOkResponse>?, t: Throwable?) {

                }
            })

        }

    }
}
