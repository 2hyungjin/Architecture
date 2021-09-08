package com.example.data.datasource

import com.example.data.response.UserResponse
import com.example.domain.model.Result

interface UserDataSource {
    suspend fun getUserList(): Result<List<UserResponse>>
}
