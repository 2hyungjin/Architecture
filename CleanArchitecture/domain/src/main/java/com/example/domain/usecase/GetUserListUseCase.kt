package com.example.domain.usecase

import com.example.domain.dto.User

interface GetUserListUseCase {
    suspend fun execute(): List<User>
}