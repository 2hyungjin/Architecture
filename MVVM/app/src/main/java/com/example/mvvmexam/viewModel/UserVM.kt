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
    private val users=repo.getAll()

    fun getAll()=users
    fun insert(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repo.insertUser(user)
        }
    }

}