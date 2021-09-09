package com.example.cleanarchitecture.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Result.Success
import com.example.domain.model.Result.Failure
import com.example.domain.model.User
import com.example.domain.usecase.GetUserListUseCase
import com.example.domain.usecase.GetUserUseCase
import kotlinx.coroutines.launch

class UserViewModel
@ViewModelInject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> = _userList
    val isLoading = MutableLiveData<Boolean>(false)
    val resultError = MutableLiveData<String>()

    fun getUserList() {
        isLoading.value = true
        viewModelScope.launch {
            when (val result = getUserListUseCase.execute()) {
                is Success -> {
                    _userList.postValue(result.data!!)
                }
                is Failure -> {
                    onError(result.message)
                }
            }
        }
    }

    fun getUser(id: String) {
        isLoading.value = true
        viewModelScope.launch {
            when (val result = getUserUseCase.execute(id)) {
                is Success -> {
                    val list= listOf<User>(result.data)
                    _userList.postValue(list)
                }
                is Failure -> {
                    onError(result.message)
                }
            }
        }
    }


    private fun onError(message: String) {
        isLoading.value = false
        resultError.postValue(message)
    }
}