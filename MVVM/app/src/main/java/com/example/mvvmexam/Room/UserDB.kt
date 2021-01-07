package com.example.mvvmexam.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1)
abstract class UserDB():RoomDatabase(){
    abstract fun getDao():UserDao
    companion object{
        private var INSTANCE : UserDB?=null
        fun getDao(context: Context): UserDao {
            if (INSTANCE==null){
                synchronized(UserDB::class.java){
                    INSTANCE=Room.databaseBuilder(
                        context.applicationContext,
                        UserDB::class.java,
                        "db"
                    ).build()
                }
            }
            return INSTANCE!!.getDao()
        }
    }
}