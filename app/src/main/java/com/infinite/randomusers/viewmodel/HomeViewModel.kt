package com.infinite.randomusers.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.infinite.randomusers.di.HomeScope
import com.infinite.randomusers.model.User
import com.infinite.randomusers.model.UserDataFormatter
import com.infinite.randomusers.repository.UserRepository
import com.infinite.randomusers.utils.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HomeScope
class HomeViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    private var pageCount: Int = 1
    private val _loadDataProgress = MutableLiveData<Boolean>().apply { value = false }
    private var _error = MutableLiveData<Int>()
    private val _userListData = MutableLiveData<List<User>>()
    private val totalUserList = ArrayList<User>()

    val userListData: LiveData<List<User>>
        get() = _userListData

    val error: LiveData<Event<Int>> = Transformations.map(_error) {
        Event(it)
    }

    val dataLoadStatus = Transformations.map(_loadDataProgress) {
        if (it) View.VISIBLE else View.GONE
    }

    fun formattedName(user: User): String {
        return UserDataFormatter(user).getFormattedName()
    }

    init {
        fetchData()
    }

    private fun fetchData() {
        scope.launch {
            userRepository.fetchRandomUserDetails(pageCount, ::onSuccess, ::onError, ::onProgress)
        }
    }

    fun fetchNextPageData() {
        if (_loadDataProgress.value == false) {
            pageCount++
            fetchData()
        }
    }

    private fun onSuccess(userList: List<User>) {
        totalUserList.addAll(userList)
        _userListData.postValue(totalUserList)
    }

    private fun onError(error: Int) {
        _error.postValue(error)
    }

    private fun onProgress(progress: Boolean) {
        _loadDataProgress.postValue(progress)
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}