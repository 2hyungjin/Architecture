package com.example.data.repository

import com.example.data.mapper.Mapper.toUserList
import com.example.data.datasource.UserDataSource
import com.example.domain.model.Result
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject


class UserRepositoryImpl
@Inject
constructor(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUserList(): Result<List<User>> {
        when (val result = userDataSource.getUserList()) {
            is Result.Success -> {
                return Result.Success(data = result.data.toUserList())
            }
            is Result.Failure -> {
                return Result.Failure(code = result.code, message = result.message)
            }
        }
    }
}