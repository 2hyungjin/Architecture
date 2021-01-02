package com.example.mvpwithretro.Contract

import com.example.mvpwithretro.Model.Network.User

interface MainContract {
    interface Model {
        interface onFinishedListener {
            fun onFinished(userList:User)
            fun onFailure(t: Throwable)
        }

        fun getMovie(onFinishedListener: onFinishedListener)
    }

    interface View {
        fun showPB()
        fun hidePB()
    }

    interface Presenter {
        fun reqData()
        fun detachV()
        fun setAdapterModel(model:AdapterContract.Model)
        fun setAdapterView(view:AdapterContract.View)
    }
}