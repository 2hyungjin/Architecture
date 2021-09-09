package com.example.domain.usecase

import com.example.domain.model.Result
import com.example.domain.model.User

interface GetUserUseCase {
    suspend fun execute(id: String): Result<User>
}