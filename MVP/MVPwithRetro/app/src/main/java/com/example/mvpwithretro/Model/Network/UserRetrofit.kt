package com.example.mvpwithretro.Model.Network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
private const val BASE_URL="https://api.github.com/"
interface MovieRetrofit {
    @GET("users")
    fun getMovie():Call<User>

    companion object{
        val getRetro = {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(MovieRetrofit::class.java)
        }
    }
}