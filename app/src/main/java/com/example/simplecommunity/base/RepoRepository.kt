package com.example.simplecommunity.base

import com.example.simplecommunity.model.SigninCheckOkResponse

interface RepoRepository {

    fun signIn(email: String, password: String, callback: BaseResponse<SigninCheckOkResponse>)


}