package com.example.mvvmexam.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmexam.Room.User
import com.example.mvvmexam.Room.UserDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class UserRepo (application: Application) {
    private val dao=UserDB.getDao(application)
    private val userList:LiveData<List<User>> = dao.selectA()
    fun getAl()=userList
    suspend fun insertUser(user:User){
        withContext(Dispatchers.IO){
            dao.insert(user)
        }
    }
}