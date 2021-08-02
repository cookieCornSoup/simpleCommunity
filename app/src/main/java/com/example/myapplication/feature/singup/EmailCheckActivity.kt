package com.example.myapplication.feature.singup

import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySigninBinding

class EmailCheckActivity : BaseActivity<ActivitySigninBinding>({ ActivitySigninBinding.inflate(it) }){

    val PREFERENCE = "com.android.signin"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            this@EmailCheckActivity,
            "이메일 인증을 마무리 해주세요",
            Toast.LENGTH_LONG
        ).show()

        binding.
    }

}