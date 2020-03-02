package com.infinite.randomusers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.infinite.randomusers.di.HomeScope
import com.infinite.randomusers.repository.UserRepository
import javax.inject.Inject

@HomeScope
class HomeViewModelFactory @Inject constructor( private val userRepository: UserRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Invalid view model class")
    }

}