package com.example.mvvmretrofit2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmretrofit2.R
import com.example.mvvmretrofit2.adapter.UserAdapter
import com.example.mvvmretrofit2.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var userVM: UserViewModel
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    fun init(){
        userAdapter= UserAdapter()
        rv.adapter=userAdapter
        rv.layoutManager=LinearLayoutManager(this)
        initVM()
    }
    fun initVM(){
        userVM=ViewModelProvider(this).get(UserViewModel::class.java)
        userVM.users.observe(this, Observer {
            userAdapter.setList(it)
        })
    }
}