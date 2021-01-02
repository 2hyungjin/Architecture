package com.example.mvpwithretro.Contract

import com.example.mvpwithretro.Model.Network.User

interface AdapterContract {
    interface View{
        fun notifyAdapter()
    }
    interface Model{
        fun setData(list:User)
    }
}