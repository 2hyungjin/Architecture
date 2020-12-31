package com.example.mvpwithretro.Presenter

import com.example.mvpwithretro.Contract.AdapterContract
import com.example.mvpwithretro.Contract.MainContract
import com.example.mvpwithretro.Model.Network.DailyBoxOffice

class MainPresenter(view: MainContract.View) : MainContract.Presenter,MainContract.Model.onFinishedListener{


    var viewNow: MainContract.View? = view
    override fun detachV() {
        viewNow = null
    }

    override fun onFinished(movieList: ArrayList<DailyBoxOffice>) {
        val adapterModel=object :AdapterContract.Model{
            override fun setData() {
                TODO("Not yet implemented")
            }

        }
        val adapterView = object :AdapterContract.View{
            override fun notifyAdapter() {

            }
        }
    }

    override fun onFailure(t: Throwable) {
        TODO("Not yet implemented")
    }

}