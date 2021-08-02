package com.example.myapplication.retrofit

import com.example.myapplication.model.SigninCheckOkResponse
import com.example.myapplication.model.UsersActivateResponse
import com.example.myapplication.model.UsersRetrieveResponse
import retrofit2.Call
import retrofit2.http.*

interface API {

    @POST("/signup")  //회원가입
    @FormUrlEncoded
    fun signUp(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("password") password : String) : Call<UsersActivateResponse>

    @POST("/auth/obtain")
    @FormUrlEncoded
    fun signIn(
        @Field("email") email: String,
        @Field("password") password : String) : Call<SigninCheckOkResponse>

    @POST("users/{email}/activate")
    @FormUrlEncoded
    fun usersActivate(
        @Path("email") email: String,
        @Field("verifying_number") verifyingNum: String) : Call<Void>


    @GET("/users/{email}")
    @FormUrlEncoded
    fun usersRetrieve(
        @Path("email") email: String) : Call<UsersRetrieveResponse>

}