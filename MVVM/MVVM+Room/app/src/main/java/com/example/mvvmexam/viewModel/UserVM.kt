package com.example.mvvmexam.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexam.Repository.UserRepo
import com.example.mvvmexam.Room.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserVM(application: Application):AndroidViewModel(application) {
    private val repo=UserRepo(application)
    //리스트 받기
    private val users=repo.getAll()
    //Live data 전달 함수
    fun getAll()=users
    //coroutine 사용해서 insert
    fun insert(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repo.insertUser(user)
        }
    }

}