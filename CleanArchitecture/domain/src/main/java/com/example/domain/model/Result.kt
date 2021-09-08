package com.example.domain.model

sealed class Result<in T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure<T>(val code: Int, val message: String) : Result<T>()
}
