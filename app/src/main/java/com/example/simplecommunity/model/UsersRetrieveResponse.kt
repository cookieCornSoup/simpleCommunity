package com.example.simplecommunity.model

data class UsersRetrieveResponse(
    val email: String,
    val name: String,
    val registration_date: String,
    val is_verified: Boolean,
    val is_active: Boolean
)
