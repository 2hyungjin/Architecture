package com.example.data.repository

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
                return Result.Success(data = result.data.map { userResponse ->
                    userResponse.toUser()
                })
            }
            is Result.Failure -> {
                return Result.Failure(code = result.code, message = result.message)
            }
        }
    }

    override suspend fun getUser(id: String): Result<User> {
        when (val result = userDataSource.getUser(id)) {
            is Result.Success -> {
                return Result.Success(result.data.toUser())
            }
            is Result.Failure -> {
                return Result.Failure(result.code, result.message)
            }
        }
    }
}