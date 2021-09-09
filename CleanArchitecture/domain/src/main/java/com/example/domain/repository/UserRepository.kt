package com.example.domain.repository

import com.example.domain.model.Result
import com.example.domain.model.User

interface UserRepository {
    suspend fun getUserList(): Result<List<User>>
    suspend fun getUser(id: String): Result<User>
}