package com.example.data.mapper

import com.example.data.response.UserResponse
import com.example.domain.model.User

object Mapper {
    fun UserResponse.toUser(): User {
        return User(
            name = login,
            url = url,
            avatar = avatar_url
        )
    }

    fun List<UserResponse>.toUserList(): List<User> {
        return map { userResponse ->
            userResponse.toUser()
        }
    }
}