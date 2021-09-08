package com.example.cleanarchitecture.di

import com.example.data.datasource.UserDataSource
import com.example.data.datasource.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton
@Module
@InstallIn(ActivityComponent::class)
abstract class UserDataSourceModule {
    @Binds
    abstract fun provideDataSource(userDataSourceImpl: UserDataSourceImpl): UserDataSource
}