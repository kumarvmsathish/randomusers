package com.infinite.randomusers.network

import android.util.Log
import com.infinite.randomusers.R
import com.infinite.randomusers.di.HomeScope
import com.infinite.randomusers.interfaces.DataSource
import com.infinite.randomusers.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HomeScope
class RemoteDataSource @Inject constructor(private val networkService: NetworkService):
    DataSource {

    override suspend fun fetchRandomUserDetails(
        pageCount: Int,
        onSuccess: (userList: List<User>) -> Unit,
        onError: (error: Int) -> Unit
    ) {
        withContext(Dispatchers.IO) {

            try {
                val randomUsers = networkService.getDoctorHomeDetailsAsync(page = pageCount).await()
                randomUsers?.let {
                    onSuccess(it.results)
                } ?: let {
                    onError(R.string.no_data_found)
                    Log.i("User Data", "No data found")

                }
            } catch (t: Throwable) {
                onError(R.string.error_while_loading_data)
                Log.e("Error User Data", "$t")

            }

        }
    }
}