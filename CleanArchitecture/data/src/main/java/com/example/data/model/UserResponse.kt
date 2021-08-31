package com.example.data.model

import kotlinx.android.parcel.Parcelize

data class UserResponse(
    val login: String,
    val avatar: String,
    val url: String
)
