package com.example.mvvmexam.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexam.Adapter.UserAdapter
import com.example.mvvmexam.R
import com.example.mvvmexam.Room.User
import com.example.mvvmexam.viewModel.UserVM
import com.example.mvvmexam.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userVM: UserVM
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        userVM.getAll().observe(this, Observer {
            userAdapter.setList(it)
        })
        button.setOnClickListener {
            userVM.insert(User("Lee", 1))
        }
    }
    //초기화
    fun init() {
        userVM = ViewModelProvider(this).get(UserVM::class.java)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        binding.vm = userVM
        userAdapter = UserAdapter()
        binding.rv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}