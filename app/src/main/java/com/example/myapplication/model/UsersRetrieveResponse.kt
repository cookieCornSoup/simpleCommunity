package com.example.myapplication.model

data class UsersRetrieveResponse(
    val email: String,
    val name: String,
    val registrationData: String,
    val isVerified: Boolean,
    val isActive: Boolean
)
