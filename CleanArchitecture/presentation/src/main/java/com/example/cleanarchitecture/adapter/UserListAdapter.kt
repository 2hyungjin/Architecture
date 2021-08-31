package com.example.cleanarchitecture.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.util.UserDiffUtill
import com.example.domain.model.User

class UserListAdapter : ListAdapter<User, UserListAdapter.ViewHolder>(UserDiffUtill()) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name_rv_item_board)
        val tvUrl: TextView = view.findViewById(R.id.tv_url_rv_item_board)
        val imgAvatar: ImageView = view.findViewById(R.id.imageView)
        fun bind(user: User) {
            tvName.text = user.login
            tvUrl.text = user.url
            imgAvatar.load(user.avatarUrl) {
                transformations(RoundedCornersTransformation())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_board, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
