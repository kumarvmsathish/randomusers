package com.infinite.randomusers.repository

import com.infinite.randomusers.di.HomeScope
import com.infinite.randomusers.network.RemoteDataSource
import com.infinite.randomusers.model.User
import javax.inject.Inject

@HomeScope
class UserRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {


    /**
     * Fetch the user related information from network and update to view model
     */
    suspend fun fetchRandomUserDetails(pageCount: Int, onSuccess: (userList: List<User>) -> Unit, onError: (error: Int) -> Unit, onProgress: (progress: Boolean) -> Unit) {
        onProgress(true)
        remoteDataSource.fetchRandomUserDetails(pageCount, onSuccess, onError)
        onProgress(false)
    }
}