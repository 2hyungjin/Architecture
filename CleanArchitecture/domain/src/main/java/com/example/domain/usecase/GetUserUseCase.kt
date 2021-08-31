package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.respository.UserRepository
class GetUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(id:String): User {
        return userRepository.getUser(id)
    }
}