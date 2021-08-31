package com.example.cleanarchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observe()
        getUsers()
        binding.btnSearch.setOnClickListener {
            getUser()
        }
    }

    private fun observe() {
        userViewModel.users.observe(this, Observer {

        })
    }

    fun getUsers() {
        userViewModel.getUsers()
    }

    fun getUser(id: String) {
        userViewModel.getUser(id)
    }
}