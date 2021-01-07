package com.example.mvvmexam.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var name: String, var age: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}