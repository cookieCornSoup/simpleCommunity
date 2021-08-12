package com.example.simplecommunity.model

enum class AccessPermission(val state:Int) {
    PRIVATE(0),
    PUBLIC(1),
    FRIENDS_PUBLIC(2)
}