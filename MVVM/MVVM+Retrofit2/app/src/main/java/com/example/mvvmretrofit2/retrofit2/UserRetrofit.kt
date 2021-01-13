package com.example.mvvmretrofit2.retrofit2

import retrofit2.Response
import retrofit2.http.GET

interface UserRetrofit {
    @GET("users")
    suspend fun getUsers():Response<ArrayList<UserItem>>
}