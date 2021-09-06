package com.example.domain.respository

import com.example.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}