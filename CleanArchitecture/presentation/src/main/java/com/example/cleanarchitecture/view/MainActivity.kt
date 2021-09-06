package com.example.cleanarchitecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.adapter.UserListAdapter
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModel()
    lateinit var userListAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observe()
        getUsers()
    }

    private fun recyclerViewInit() {
        userListAdapter = UserListAdapter()
        val rv = binding.rvBoardMain
        rv.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observe() {
        userViewModel.users.observe(this, Observer {
            userListAdapter.notifyDataSetChanged()
        })
    }

    private fun getUsers() {
        userViewModel.getUsers()
    }

}