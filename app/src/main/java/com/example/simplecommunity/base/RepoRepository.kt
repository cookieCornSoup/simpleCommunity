package com.example.simplecommunity.base

import com.example.simplecommunity.model.SigninCheckOkResponse
import com.example.simplecommunity.model.SigninDTO

interface RepoRepository {

    fun signIn(signinDTO: SigninDTO, callback: BaseResponse<SigninCheckOkResponse>)

}