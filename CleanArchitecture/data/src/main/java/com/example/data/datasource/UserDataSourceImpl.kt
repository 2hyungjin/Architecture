package com.example.data.datasource

import com.example.data.api.UserApi
import com.example.data.response.UserResponse
import com.example.domain.model.Result
import javax.inject.Inject

class UserDataSourceImpl
@Inject constructor(private val userApi: UserApi) : UserDataSource {
    override suspend fun getUserList(): Result<List<UserResponse>> {
        val response = userApi.getUserList()
        if (response.isSuccessful) {
            return Result.Success(response.body()!!)
        } else {
            return Result.Failure(response.code(), response.message())
        }
    }

}