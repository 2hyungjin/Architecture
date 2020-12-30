package com.example.mvpexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpexam.presentor.Contract
import com.example.mvpexam.presentor.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Contract.View{
    private lateinit var presenter : Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter=Presenter().apply {
            attachView(this@MainActivity)
        }
        btn_change.setOnClickListener { changeText() }
        btn_get.setOnClickListener { presenter.getData() }
    }


    override fun getText(t: String) {
        textView.text=t
    }

    override fun changeText() {
        val t=edt.text.toString()
        presenter.setData(t)
    }
}