package com.example.mvvmretrofit2.repository

import com.example.mvvmretrofit2.retrofit2.RetrofitInstance

class UserRepo {
    suspend fun getUsers()=RetrofitInstance.userApi.getUsers()
}