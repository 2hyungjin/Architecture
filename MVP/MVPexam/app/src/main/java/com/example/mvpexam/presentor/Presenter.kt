package com.example.mvpexam.presentor

import com.example.mvpexam.Data

class Presenter:Contract.Presenter {
    private var viewNow : Contract.View? =null
    override fun attachView(view: Contract.View) {
        viewNow=view
    }
    override fun detachView() {
        viewNow=null
    }

    override fun getData() {
        val t=Data.t
        viewNow?.getText(t)
    }

    override fun setData(t:String) {
        Data.t=t
    }


}