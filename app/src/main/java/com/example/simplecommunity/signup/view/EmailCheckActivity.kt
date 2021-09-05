package com.example.simplecommunity.signup.view

import android.os.Bundle
import android.widget.Toast
import com.example.simplecommunity.base.BaseActivity
import com.example.simplecommunity.base.BaseResponse
import com.example.simplecommunity.databinding.ActivityEmailCheckBinding
import com.example.simplecommunity.model.signup.EmailCheckDTO
import com.example.simplecommunity.model.signup.EmailCheckResponse
import com.example.simplecommunity.signup.viewmodel.EmailCheckViewModel

class EmailCheckActivity : BaseActivity<ActivityEmailCheckBinding>({ ActivityEmailCheckBinding.inflate(it) }){

    private lateinit var emailCheckViewModel: EmailCheckViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            this@EmailCheckActivity,
            "이메일 인증을 마무리 해주세요",
            Toast.LENGTH_LONG
        ).show()


        binding.emailCheckBtn.setOnClickListener{

            val emailCheckDTO = EmailCheckDTO(
                binding.signInIdEditText.text.toString(),
                intent.getParcelableArrayExtra("email").toString()
            )
            emailCheckViewModel.emailCheck(emailCheckDTO, object : BaseResponse<EmailCheckResponse>{
                override fun onSuccess(data: EmailCheckResponse) {
                    TODO("Not yet implemented")
                }

                override fun onFail(description: String) {
                    TODO("Not yet implemented")
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