package com.example.myapplication.feature.singup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySignupBinding
import com.example.myapplication.feature.MainActivity
import com.example.myapplication.model.UsersActivateResponse
import com.example.myapplication.repository.SharedPref
import com.example.myapplication.retrofit.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : BaseActivity<ActivitySignupBinding>({ ActivitySignupBinding.inflate(it) }) {

    val PREFERENCE = "com.android.signin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpBtn.setOnClickListener {
            Client.retrofitService.signUp(
                binding.signUpIdEditText.toString(),
                binding.signUpNikenameEditText.toString(),
                binding.signUpPasswordEditText.toString()
            ).enqueue(object : Callback<UsersActivateResponse> {
                @SuppressLint("ShowToast")
                override fun onResponse(
                    call: Call<UsersActivateResponse>?,
                    response: Response<UsersActivateResponse>?
                ) {
                    when (response!!.code()) {
                        200 -> {
                            val intent = Intent(this@SignupActivity, EmailCheckActivity::class.java)
                            intent.putExtra("email",response.body()?.email.toString())
                            startActivity(intent)
                        }
                        405 -> Toast.makeText(
                            this@SignupActivity,
                            "로그인 실패 : 아이디나 비번이 올바르지 않습니다",
                            Toast.LENGTH_LONG
                        ).show()
                        500 -> Toast.makeText(
                            this@SignupActivity,
                            "로그인 실패 : 서버 오류",
                            Toast.LENGTH_LONG
                        ).show()
                        401 -> Toast.makeText(
                            this@SignupActivity,
                            "잘못된 인증자격(리프레시 토큰으로 바꾸기)",
                            Toast.LENGTH_LONG
                        )
                    }
                }

                override fun onFailure(call: Call<UsersActivateResponse>, t: Throwable) {

                }
            })

        }
    }
}
