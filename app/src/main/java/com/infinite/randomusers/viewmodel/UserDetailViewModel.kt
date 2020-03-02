package com.infinite.randomusers.viewmodel

import androidx.lifecycle.ViewModel
import com.infinite.randomusers.di.UserDataScope
import com.infinite.randomusers.model.User
import com.infinite.randomusers.model.UserDataFormatter
import javax.inject.Inject

@UserDataScope
class UserDetailViewModel @Inject constructor(val user: User) : ViewModel() {

    private val userDataFormatter: UserDataFormatter = UserDataFormatter(user)

    fun formattedName(): String = userDataFormatter.getFormattedName()

    fun formattedDobAge(): String = userDataFormatter.getDobAgeFormatted()

    fun formattedLocation(): String = userDataFormatter.getLocationFormatted()


}