package com.example.data.repository

import com.example.data.Mapper.UserMapper
import com.example.data.datasource.UserDataSource
import com.example.domain.model.User
import com.example.domain.respository.UserRepository

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return UserMapper().toUsers(userDataSource.getUsers())
    }

    override suspend fun getUser(id: String): User {
        return UserMapper().toUser(userDataSource.getUser(id))
    }

}