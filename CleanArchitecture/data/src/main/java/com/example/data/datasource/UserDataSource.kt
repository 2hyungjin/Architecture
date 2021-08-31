package com.example.data.datasource

import com.example.data.api.UserApi
import com.example.data.model.UserResponse

interface UserDataSource {
    suspend fun getUsers(): List<UserResponse>
    suspend fun getUser(id: String): UserResponse
}

class UserDataSourceImpl(private val userApi: UserApi) : UserDataSource {
    override suspend fun getUsers(): List<UserResponse> {
        return userApi.getUsers()
    }

    override suspend fun getUser(id: String): UserResponse {
        return userApi.getUser(id)
    }

}