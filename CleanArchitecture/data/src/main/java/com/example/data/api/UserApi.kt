package com.example.data.api

import com.example.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path


interface UserApi {
    @GET("/users")
    suspend fun getUsers(): List<UserResponse>

    @GET("/users/{id}")
    suspend fun getUser(@Path("id") id: String): UserResponse


}