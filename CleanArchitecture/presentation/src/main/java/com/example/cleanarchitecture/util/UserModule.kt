package com.example.cleanarchitecture.util

import com.example.cleanarchitecture.viewmodel.UserViewModel
import com.example.data.api.UserApi
import com.example.data.datasource.UserDataSource
import com.example.data.datasource.UserDataSourceImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.respository.UserRepository
import com.example.domain.usecase.GetUsersUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val userModule = module {
    single<UserApi> {
        Retrofit.Builder().baseUrl("https://api.github.com")
            .build()
            .create(UserApi::class.java)
    }
    factory<UserDataSource> { UserDataSourceImpl(get()) }
    factory<UserRepository> { UserRepositoryImpl(get()) }
    factory { GetUsersUseCase(get()) }
    viewModel { UserViewModel(get()) }
}