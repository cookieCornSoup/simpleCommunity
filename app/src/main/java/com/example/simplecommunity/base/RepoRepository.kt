package com.example.simplecommunity.base

import com.example.simplecommunity.model.signin.SigninCheckOkResponse
import com.example.simplecommunity.model.signin.SigninDTO
import com.example.simplecommunity.repository.SharedPref

interface RepoRepository {

    fun signIn(signinDTO: SigninDTO, callback: BaseResponse<SigninCheckOkResponse>, sharedPref: SharedPref)

    fun signUp(sign)
}