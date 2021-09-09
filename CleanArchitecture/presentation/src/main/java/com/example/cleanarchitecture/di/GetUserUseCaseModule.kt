package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.usecase.GetUserUseCaseImpl
import com.example.domain.usecase.GetUserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class GetUserUseCaseModule {
    @Binds
    abstract fun provideGetUserUseCase(getUserUseCaseImpl: GetUserUseCaseImpl):GetUserUseCase
}