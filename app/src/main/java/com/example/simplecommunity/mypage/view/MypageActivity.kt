package com.example.simplecommunity.mypage.view

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.simplecommunity.base.BaseActivity
import com.example.simplecommunity.databinding.ActivitySignupBinding
import com.example.simplecommunity.mypage.viewmodel.MypageViewModel
import com.example.simplecommunity.signup.viewmodel.SignupViewModel
import com.example.simplecommunity.utils.InputUtility

class MypageActivity : BaseActivity<ActivitySignupBinding>({ ActivitySignupBinding.inflate(it) }) {

    private lateinit var mypageViewModel: MypageViewModel

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}