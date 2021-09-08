package com.example.cleanarchitecture.di

import com.example.cleanarchitecture.usecase.GetUserListUseCaseImpl
import com.example.domain.usecase.GetUserListUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class GetUserListUseCaseModule {
    @Binds
    abstract fun provideGetUserListUserCase(getUserListUseCaseImpl: GetUserListUseCaseImpl): GetUserListUseCase
}