package com.example.cleanarchitecture.usecase

import com.example.domain.model.Result
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.GetUserListUseCase
import dagger.Module
import javax.inject.Inject

class GetUserListUseCaseImpl
@Inject
constructor(private val userRepository: UserRepository) : GetUserListUseCase {
    override suspend fun execute(): Result<List<User>> {
        return userRepository.getUserList()
    }
}