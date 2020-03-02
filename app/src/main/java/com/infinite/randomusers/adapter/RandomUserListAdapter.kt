package com.infinite.randomusers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.infinite.randomusers.databinding.ListItemRandomUsersBinding
import com.infinite.randomusers.interfaces.IListItemClickListener
import com.infinite.randomusers.model.User
import com.infinite.randomusers.viewmodel.HomeViewModel
import org.jetbrains.annotations.NotNull

class RandomUserListAdapter constructor(@NotNull private val viewModel: HomeViewModel, @NotNull private val onItemClickListener: IListItemClickListener) : ListAdapter<User, RandomUserListAdapter.RandomUserViewHolder>(DiffCallBack) {


    companion object DiffCallBack: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(
            oldItem: User,
            newItem: User
        ): Boolean {
           return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: User,
            newItem: User
        ): Boolean {
            return oldItem.email == newItem.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        return RandomUserViewHolder(ListItemRandomUsersBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClickListener.onClick(user = item)
        }
    }

    inner class RandomUserViewHolder(private val binding: ListItemRandomUsersBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(user: User) {
            binding.user = user
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

}