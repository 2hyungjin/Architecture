package com.example.mvvmretrofit2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofit2.repository.UserRepo
import com.example.mvvmretrofit2.retrofit2.UserItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel() : ViewModel() {
    private val repo: UserRepo=UserRepo()
    val users = MutableLiveData<ArrayList<UserItem>>()

    init {
        getUsers()
        Log.d("TAG","NETWORK")
    }

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getUsers().let { res ->
                if (res.isSuccessful) {
                    users.postValue(res.body())
                    Log.d("TAG",res.body().toString())
                }
            }
        }
    }

}