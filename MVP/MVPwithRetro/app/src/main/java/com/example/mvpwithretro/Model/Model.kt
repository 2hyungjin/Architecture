package com.example.mvpwithretro.Model

import com.example.mvpwithretro.Model.Network.Movie
import com.example.mvpwithretro.Model.Network.MovieRetrofit
import com.example.mvpwithretro.Contract.MainContract
import com.example.mvpwithretro.Model.Network.DailyBoxOffice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Model : MainContract.Model{
    private val movieList:ArrayList<DailyBoxOffice>?= arrayListOf<DailyBoxOffice>()
    override fun getMovie(onFinishedListener: MainContract.Model.onFinishedListener) {
        MovieRetrofit.getRetro().getMovie().enqueue(object :Callback<Movie>{
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val res=response.body()?.boxOfficeResult?.dailyBoxOfficeList
                if (res != null) {
                    for (i in res){
                        movieList?.add(i)
                    }
                    if (movieList != null) {
                        onFinishedListener.onFinished(movieList)
                    }
                }
            }
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }

        })
    }
}