package com.example.simplecommunity.feature.signup

import android.os.Bundle
import android.widget.Toast
import com.example.simplecommunity.base.BaseActivity
import com.example.simplecommunity.databinding.ActivityEmailCheckBinding

class EmailCheckActivity : BaseActivity<ActivityEmailCheckBinding>({ ActivityEmailCheckBinding.inflate(it) }){

    val PREFERENCE = "com.android.signin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            this@EmailCheckActivity,
            "이메일 인증을 마무리 해주세요",
            Toast.LENGTH_LONG
        ).show()



    }

}