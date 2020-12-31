package com.example.mvpwithretro.Contract

interface AdapterContract {
    interface View{
        fun notifyAdapter()
    }
    interface Model{
        fun setData()
    }
}