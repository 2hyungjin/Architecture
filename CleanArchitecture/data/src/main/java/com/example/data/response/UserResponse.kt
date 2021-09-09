package com.example.data.response

import com.example.domain.model.User

data class UserResponse(
    val login: String,
    val url: String,
    val avatar_url: String
) {
    fun toUser(): User {
        return User(
            name = login,
            url = url,
            avatar = avatar_url
        )
    }
}