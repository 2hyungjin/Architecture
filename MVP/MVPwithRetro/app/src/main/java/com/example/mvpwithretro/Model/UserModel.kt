package com.example.mvpwithretro.Model

import android.util.Log
import com.example.mvpwithretro.Model.Network.MovieRetrofit
import com.example.mvpwithretro.Contract.MainContract
import com.example.mvpwithretro.Model.Network.User
import com.example.mvpwithretro.Model.Network.UserItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserModel : MainContract.Model{
    override fun getMovie(onFinishedListener: MainContract.Model.onFinishedListener) {
        MovieRetrofit.getRetro().getMovie().enqueue(object :Callback<User>{
            override fun onResponse(call: Call<User>, response: Response<User>) {
                val res=response.body()
                Log.d("TAG",res.toString())
                onFinishedListener.onFinished(res!!)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }

        })
    }
}