package com.example.mvvmexam.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmexam.Room.User
import com.example.mvvmexam.Room.UserDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class UserRepo (application: Application) {
    private val dao=UserDB.getDao(application)

    //리스트 받아오기
    private val userList:LiveData<List<User>> = dao.selectA()
    //리스트 반환
    fun getAll()=userList
    //insert
    suspend fun insertUser(user:User){
        dao.insert(user)
    }
}