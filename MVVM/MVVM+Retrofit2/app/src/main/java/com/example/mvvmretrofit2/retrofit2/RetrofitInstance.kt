package com.example.mvvmretrofit2.retrofit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private val BASE_URL="https://api.github.com/"
class RetrofitInstance {
    companion object {
        private val userRetrofit by lazy{
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
        val userApi by lazy{
            userRetrofit.create(UserRetrofit::class.java)
        }
    }

}