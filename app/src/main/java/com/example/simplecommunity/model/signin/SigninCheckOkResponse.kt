package com.example.simplecommunity.model.signin

data class SigninCheckOkResponse(
    val access_token: String,
    val refresh_token: String,
    val email: String
)
