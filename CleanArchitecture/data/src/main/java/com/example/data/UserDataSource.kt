package com.example.data

import retrofit2.Response

interface UserDataSource {
    suspend fun getUserList(): List<UserResponse>
}
