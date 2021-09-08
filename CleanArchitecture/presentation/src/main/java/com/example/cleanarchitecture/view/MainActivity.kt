package com.example.cleanarchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.adapter.UserListAdapter
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
    lateinit var userListAdapter: UserListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        rvInit()
        observe()
        userViewModel.getUserList()
    }

    private fun rvInit() {
        userListAdapter = UserListAdapter()
        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userListAdapter
        }
    }

    private fun observe() {
        userViewModel.userList.observe(this, Observer { userList ->
            userListAdapter.submitList(userList)
        })
    }
}