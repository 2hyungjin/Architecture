package com.example.data

import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UserDataSourceImpl
@Inject constructor(private val userApi: UserApi) : UserDataSource {
    override suspend fun getUserList(): List<UserResponse> {
        val response = userApi.getUserList()
        return if (response.isSuccessful) {
            return response.body()!!
        } else {
            emptyList()
        }
    }

}