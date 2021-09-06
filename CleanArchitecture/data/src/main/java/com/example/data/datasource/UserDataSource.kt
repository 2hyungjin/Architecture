package com.example.data.datasource

import com.example.data.api.UserApi
import com.example.data.model.UserResponse
import com.example.domain.model.User

interface UserDataSource {
    suspend fun getUsers(): List<UserResponse>
}

class UserDataSourceImpl(private val userApi: UserApi) : UserDataSource {
    override suspend fun getUsers(): List<UserResponse> {
        userApi.getUsers().let {
            if (it.isSuccessful) {
                return it.body()!!
            } else {
                return emptyList()
            }
        }
    }


}