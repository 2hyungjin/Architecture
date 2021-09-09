package com.example.cleanarchitecture.usecase

import com.example.domain.model.Result
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.GetUserUseCase
import javax.inject.Inject

class GetUserUseCaseImpl
@Inject constructor(private val repository: UserRepository) : GetUserUseCase {
    override suspend fun execute(id: String): Result<User> {
        return repository.getUser(id)
    }
}