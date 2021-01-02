package com.example.mvpwithretro.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpwithretro.Adapter.UserAdapter
import com.example.mvpwithretro.Contract.MainContract
import com.example.mvpwithretro.Presenter.MainPresenter
import com.example.mvpwithretro.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainContract.View {
    lateinit var presenter: MainContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userAdapter=UserAdapter()
        rv.layoutManager=LinearLayoutManager(this)
        rv.adapter=userAdapter
        presenter=MainPresenter(this)
        presenter.apply {
            setAdapterModel(userAdapter)
            setAdapterView(userAdapter)
            reqData()
        }
    }

    override fun showPB() {
        //show progress bar
        TODO("Not yet implemented")
    }

    override fun hidePB() {
        //hide progress bar
        TODO("Not yet implemented")
    }

}