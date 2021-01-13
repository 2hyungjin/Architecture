package com.example.mvvmretrofit2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmretrofit2.R
import com.example.mvvmretrofit2.retrofit2.UserItem

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserVH>() {
    private var list = emptyList<UserItem>()

    class UserVH(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvUrl = view.findViewById<TextView>(R.id.tv_url)
        fun bind(user: UserItem) {
            tvName.text = user.login
            tvUrl.text = user.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return UserVH(view)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setList(users: ArrayList<UserItem>) {
        list = users
        notifyDataSetChanged()
    }


}