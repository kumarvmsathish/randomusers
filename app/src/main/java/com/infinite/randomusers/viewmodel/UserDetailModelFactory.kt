package com.infinite.randomusers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infinite.randomusers.di.UserDataScope
import com.infinite.randomusers.model.User
import javax.inject.Inject

@UserDataScope
class UserDetailModelFactory @Inject constructor( val user: User): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
            return UserDetailViewModel(user) as T
        }
        throw IllegalArgumentException("Invalid view model class")
    }

}