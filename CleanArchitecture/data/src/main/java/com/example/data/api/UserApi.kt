package com.example.data.api

import com.example.data.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUserList(): Response<List<UserResponse>>
}