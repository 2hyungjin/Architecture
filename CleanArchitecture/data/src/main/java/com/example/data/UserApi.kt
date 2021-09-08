package com.example.data

import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET
    suspend fun getUserList(): Response<List<UserResponse>>
}