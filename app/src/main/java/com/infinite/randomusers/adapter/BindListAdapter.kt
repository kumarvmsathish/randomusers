package com.infinite.randomusers.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.infinite.randomusers.model.User

@BindingAdapter("listData")
fun loadUserList(recyclerView: RecyclerView, listData: List<User>?) {
    listData?.let {
        val adapter = recyclerView.adapter as RandomUserListAdapter
        adapter.submitList(it)
    }

}