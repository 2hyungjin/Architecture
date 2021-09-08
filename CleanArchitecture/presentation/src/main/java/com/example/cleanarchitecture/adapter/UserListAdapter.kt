package com.example.cleanarchitecture.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.cleanarchitecture.R
import com.example.domain.model.User

class UserListAdapter : ListAdapter<User, UserListAdapter.ViewHolder>(UserDiffUtil()) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvName: TextView = view.findViewById(R.id.tv_id_rv_item)
        private val tvUrl: TextView = view.findViewById(R.id.tv_url_rv_item)
        private val imgAvatar: ImageView = view.findViewById(R.id.imageView)
        fun bind(user: User) {
            tvName.text = user.name
            tvUrl.text = user.url
            imgAvatar.load(user.avatar) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}