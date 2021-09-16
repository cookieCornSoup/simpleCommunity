package com.example.simplecommunity.mypage.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.simplecommunity.mypage.repository.MypageRepository

class MypageViewModel (application: Application) : AndroidViewModel(application){

    private val repository = MypageRepository()



}