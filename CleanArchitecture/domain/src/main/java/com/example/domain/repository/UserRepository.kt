package com.example.domain.repository

import com.example.domain.dto.User

interface UserRepository {
    suspend fun getUserList(): List<User>

}