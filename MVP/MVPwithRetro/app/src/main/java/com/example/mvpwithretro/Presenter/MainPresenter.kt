package com.example.mvpwithretro.Presenter

import android.util.Log
import com.example.mvpwithretro.Contract.AdapterContract
import com.example.mvpwithretro.Contract.MainContract
import com.example.mvpwithretro.Model.Network.User
import com.example.mvpwithretro.Model.UserModel

class MainPresenter(view: MainContract.View) : MainContract.Presenter,MainContract.Model.onFinishedListener{
    private var viewNow: MainContract.View? = view
    private lateinit var adapterModel:AdapterContract.Model
    private lateinit var adapterView:AdapterContract.View
    private val model:MainContract.Model?=UserModel()
    override fun reqData() {
        model?.getMovie(this)
    }

    override fun detachV() {
        viewNow = null
    }

    override fun setAdapterModel(model: AdapterContract.Model) {
        this.adapterModel=model
    }

    override fun setAdapterView(view: AdapterContract.View) {
        this.adapterView=view
    }

    override fun onFinished(userList: User) {
        Log.d("TAG","suc + $userList")
        adapterModel.setData(list = userList)
        adapterView.notifyAdapter()
    }

    override fun onFailure(t: Throwable) {
        Log.d("TAG","Fail")
        //통신 실패시(ex Toast)
    }

}