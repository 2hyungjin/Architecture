package com.example.mvpwithretro.Adapter

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpwithretro.Contract.AdapterContract
import com.example.mvpwithretro.Model.Network.User
import com.example.mvpwithretro.Model.Network.UserItem
import com.example.mvpwithretro.R

class UserAdapter : RecyclerView.Adapter<UserAdapter.mViewHolder>(), AdapterContract.View,
    AdapterContract.Model {
    var list:User= User()
    lateinit var context:Context
    inner class mViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tv=view.findViewById<TextView>(R.id.textView)
        val img=view.findViewById<ImageView>(R.id.imageView)
        fun bind(user:UserItem){
            tv.text= user.login
            Glide.with(context)
                .load(user.avatarUrl)
                .into(img)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        context=parent.context
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return mViewHolder(view)
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.bind(list[position])
        Log.d("TAG","bind : ${list[position]}")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun notifyAdapter() {
        notifyDataSetChanged()
        Log.d("TAG","notify")
    }

    override fun setData(list: User) {
        this.list=list
        Log.d("TAG","setData : ${this.list}")
    }

}