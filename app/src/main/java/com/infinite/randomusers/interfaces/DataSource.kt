package com.infinite.randomusers.interfaces

import com.infinite.randomusers.model.User

interface DataSource {

    suspend fun fetchRandomUserDetails(pageCount: Int, onSuccess: (userList: List<User>) -> Unit, onError: (error: Int) -> Unit) // onProgress: (progress: Boolean) -> Unit

}