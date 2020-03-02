package com.infinite.randomusers.interfaces

import com.infinite.randomusers.model.User

interface IListItemClickListener {
    fun onClick(user: User)
}