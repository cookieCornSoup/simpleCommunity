package com.example.simplecommunity.feature.signup

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.simplecommunity.base.BaseActivity
import com.example.simplecommunity.base.BaseResponse

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

            val signinDTO = SigninDTO(
                binding.signInIdEditText.text.toString(),
                binding.signInPasswordEditText.text.toString()
            )

            signinViewModel.signIn(signinDTO, object : BaseResponse<SigninCheckOkResponse> {
                override fun onSuccess(data: SigninCheckOkResponse) {
                    val intent = Intent(this@SigninActivity, MainActivity::class.java)
                    startActivity(intent)
                }

                override fun onFail(description: String) {
                    TODO("Not yet implemented")
                }

                override fun onError(throwable: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onLoading() {
                    TODO("Not yet implemented")
                }

                override fun onLoaded() {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}
