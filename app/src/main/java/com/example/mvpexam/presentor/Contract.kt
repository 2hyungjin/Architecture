package com.example.mvpexam.presentor

import android.view.View

interface Contract {
    interface View{
        fun getText(t:String)
        fun changeText()
    }
    interface Presenter{
        fun attachView(view:View)
        fun detachView()
        fun getData()
        fun setData(t:String)
    }
}