package com.example.simplecommunity.model

data class FeedsCreateResponse(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val registration_date: String,
    val contents: String,
    val access_permission: AccessPermission,
    val user: String
)
