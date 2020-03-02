package com.infinite.randomusers.di

import com.infinite.randomusers.model.User
import com.infinite.randomusers.ui.fragment.UserDetailFragment
import dagger.BindsInstance
import dagger.Subcomponent

@UserDataScope
@Subcomponent
interface UserComponent {

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        fun setUser(user: User): Builder
        fun build(): UserComponent
    }

    fun inject(userDetailFragment: UserDetailFragment)

}