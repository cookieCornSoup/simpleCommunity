package com.example.simplecommunity.signin.view

import android.content.Intent
import android.os.Bundle
import com.example.simplecommunity.base.BaseActivity
import com.example.simplecommunity.base.BaseResponse

import com.example.simplecommunity.databinding.ActivitySigninBinding
import com.example.simplecommunity.feature.MainActivity
import com.example.simplecommunity.model.signin.SigninCheckOkResponse
import com.example.simplecommunity.model.signin.SigninDTO
import com.example.simplecommunity.signin.viewmodel.SigninViewModel

class SigninActivity : BaseActivity<ActivitySigninBinding>({ ActivitySigninBinding.inflate(it) }) {

    private lateinit var signinViewModel: SigninViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.autoSignInCheckbox.setOnClickListener {
            signinViewModel.autoLogin(binding.autoSignInCheckbox.isChecked)
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

                }

                override fun onFail(description: String, newAuthentication: Boolean) {
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
