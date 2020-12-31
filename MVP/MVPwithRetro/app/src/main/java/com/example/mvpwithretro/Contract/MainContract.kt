package com.example.mvpwithretro.Contract

import com.example.mvpwithretro.Model.Network.DailyBoxOffice
import com.example.mvpwithretro.Model.Network.Movie

interface MainContract {
    interface Model {
        interface onFinishedListener {
            fun onFinished(movieList: ArrayList<DailyBoxOffice>)
            fun onFailure(t: Throwable)
        }

        fun getMovie(onFinishedListener: onFinishedListener)
    }

    interface View {
        fun showPB()
        fun hidePB()
    }

    interface Presenter {
        fun detachV()
    }
}