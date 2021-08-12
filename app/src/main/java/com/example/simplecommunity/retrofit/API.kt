package com.example.simplecommunity.retrofit

import com.example.simplecommunity.model.*
import retrofit2.Call
import retrofit2.http.*
import java.net.URI

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

    @POST("/users/{email}/activate")
    @FormUrlEncoded
    fun usersActivate(
        @Path("email") email: String,
        @Field("verifying_number") verifyingNum: String) : Call<Void>



    @GET("/users/{email}")
    fun usersRetrieve(
        @Header("Authorization") auth: String,
        @Path("email") email: String) : Call<UsersRetrieveResponse>

    @POST("/feeds")
    @FormUrlEncoded
    fun feedsCreate(
        @Field("title") title: String,
        @Field("thumbnail") thumbnail : String,
        @Field("contents") contents: String,
        @Field("access_permission") is_show : Boolean) : Call<FeedsCreateResponse>

    @POST("/images")
    @FormUrlEncoded
    fun imagesCreate(
        @Field("image") image: URI,
        @Field("path") path : String,
        @Field("name") name: String) : Call<ImagesCreateResponse>

}