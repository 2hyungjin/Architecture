package com.example.mvpwithretro.Model.Network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
private const val BASE_URL="https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?"
interface MovieRetrofit {
    @GET("key=11dce64cfff9d2bbb48279ce517a092c&targetDt=20201230")
    fun getMovie():Call<Movie>

    companion object{
        val getRetro = {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build().create(MovieRetrofit::class.java)
        }
    }
}