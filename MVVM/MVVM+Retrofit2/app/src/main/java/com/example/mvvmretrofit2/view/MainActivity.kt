package com.example.mvvmretrofit2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmretrofit2.R
import com.example.mvvmretrofit2.adapter.UserAdapter
import com.example.mvvmretrofit2.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var userVM: UserViewModel
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
}