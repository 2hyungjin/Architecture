package com.example.cleanarchitecture.util

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.User

class UserDiffUtill : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}