package com.example.mvpwithretro.Presenter

import com.example.mvpwithretro.Adapter.movieAdapter
import com.example.mvpwithretro.Contract.AdapterContract
import com.example.mvpwithretro.Contract.MainContract
import com.example.mvpwithretro.Model.Network.DailyBoxOffice

class MainPresenter(view: MainContract.View) : MainContract.Presenter,MainContract.Model.onFinishedListener{
    var viewNow: MainContract.View? = view
    var adapterModel=movieAdapter()
    override fun detachV() {
        viewNow = null
    }

    override fun onFinished(movieList: ArrayList<DailyBoxOffice>) {
        movieAdapter.setData()
    }

    override fun onFailure(t: Throwable) {
        TODO("Not yet implemented")
    }

}