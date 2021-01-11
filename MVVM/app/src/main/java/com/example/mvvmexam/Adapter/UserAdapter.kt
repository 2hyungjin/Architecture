package com.example.mvvmexam.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexam.R
import com.example.mvvmexam.Room.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserVH>() {
    private var userList= emptyList<User>()
    class UserVH(view:View) : RecyclerView.ViewHolder(view){
        val tvName=view.findViewById<TextView>(R.id.tv_name)
        val tvAge=view.findViewById<TextView>(R.id.tv_age)
        fun bind(user:User){
            tvName.text=user.name
            tvAge.text=user.age.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val view = LayoutInflater.from(parent.context).inflate( R.layout.rv_item,parent,false)
        return UserVH(view)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    //List update 함수
    fun setList(list:List<User>){
        userList=list
        notifyDataSetChanged()
    }
}