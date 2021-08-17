package com.example.simplecommunity.feature.signup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.simplecommunity.base.BaseActivity

import com.example.simplecommunity.databinding.ActivitySigninBinding
import com.example.simplecommunity.feature.MainActivity
import com.example.simplecommunity.model.SigninCheckOkResponse
import com.example.simplecommunity.model.SigninDTO
import com.example.simplecommunity.repository.SharedPref
import com.example.simplecommunity.retrofit.Client
import com.example.simplecommunity.signin.viewmodel.SigninViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SigninActivity : BaseActivity<ActivitySigninBinding>({ ActivitySigninBinding.inflate(it) }) {

    private lateinit var signinViewModel: SigninViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        SharedPref.init(this)

        binding.autoSignInCheckbox.setOnClickListener {
            SharedPref.autoLogin = binding.autoSignInCheckbox.isChecked
        }

        binding.signInBtn.setOnClickListener {

            var signinDTO = SigninDTO(binding.signInIdEditText.text.toString(),
            binding.signInPasswordEditText.text.toString())

            signinViewModel.signIn(signinDTO)








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
                            SharedPref.access_token = response.body()?.access_token.toString()
                            SharedPref.refresh_token = response.body()?.refresh_token.toString()
                            SharedPref.email = signinDTO.email

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
