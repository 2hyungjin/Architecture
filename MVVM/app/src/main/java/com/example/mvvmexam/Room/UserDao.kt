package com.example.mvvmexam.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user:User)
    @Query("select * from user")
    fun selectA():LiveData<List<User>>
}