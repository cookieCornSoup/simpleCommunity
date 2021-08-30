package com.example.simplecommunity.base

interface BaseResponse<T> {

    fun onSuccess(data: T)

    fun onFail(description: String)

    fun onFail(description: String, newAuthentication: Boolean)

    fun onError(throwable: Throwable)

    fun onLoading()

    fun onLoaded()
}