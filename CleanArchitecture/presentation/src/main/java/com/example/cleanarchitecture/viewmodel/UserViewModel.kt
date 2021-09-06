package com.example.cleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.User
import com.example.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _user: MutableLiveData<List<User>> = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _user

    fun getUsers() {
        viewModelScope.launch {
            _user.value = getUsersUseCase.invoke()
        }
    }
}