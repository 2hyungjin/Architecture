package com.example.mvvmexam.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmexam.Room.User
import com.example.mvvmexam.Room.UserDB

class UserRepo (application: Application) {
    private val dao=UserDB.getDao(application)
    private val userList:LiveData<List<User>> = dao.selectA()

    fun insertUser(user:User){
    ViewModel
    }
}