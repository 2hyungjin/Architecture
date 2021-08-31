package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.respository.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(): List<User> {
        return userRepository.getUsers()
    }
}