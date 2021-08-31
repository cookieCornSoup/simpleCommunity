package com.example.simplecommunity.signup.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simplecommunity.base.BaseActivity
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.databinding.ActivitySignupBinding
import com.example.simplecommunity.feature.signup.EmailCheckActivity
import com.example.simplecommunity.model.signup.SignupDTO
import com.example.simplecommunity.model.signup.UsersActivateResponse
import com.example.simplecommunity.signup.viewmodel.SignupViewModel
import com.example.simplecommunity.utils.InputUtility

class SignupActivity : BaseActivity<ActivitySignupBinding>({ ActivitySignupBinding.inflate(it) }) {

    private lateinit var signupViewModel: SignupViewModel
    private lateinit var inputUtility: InputUtility


    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpBtn.setOnClickListener {
            val signupDTO = SignupDTO(
                binding.signUpIdEditText.text.toString(),
                binding.signUpNikenameEditText.text.toString(),
                binding.signUpPasswordEditText.text.toString()
            )
            signupViewModel.signup(signupDTO, object : BaseResponse<UsersActivateResponse> {
                override fun onSuccess(data: UsersActivateResponse) {
                    val intent = Intent(this@SignupActivity, EmailCheckActivity::class.java)
                    intent.putExtra("email", signupDTO.email)

                    startActivity(intent)
                }

                override fun onFail(description: String) {
                    Toast.makeText(this@SignupActivity, description, Toast.LENGTH_LONG).show()
                }

                override fun onFail(description: String, newAuthentication: Boolean) {
                    Toast.makeText(this@SignupActivity, description, Toast.LENGTH_LONG).show()
                    val intent = Intent(this@SignupActivity, SignupActivity::class.java)
                    startActivity(intent)
                }

                override fun onError(throwable: Throwable) {

                }

                override fun onLoading() {
                    inputUtility.hideKeyborad(this@SignupActivity)


                }

                override fun onLoaded() {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}

