package com.infinite.randomusers.di

import com.infinite.randomusers.ui.fragment.HomeFragment
import dagger.Subcomponent

@HomeScope
@Subcomponent
interface HomeComponent {

    @Subcomponent.Builder
    interface Builder{
//        @BindsInstance
//        fun setHomeFragmentModule(homeFragment: HomeFragment): Builder
        fun build(): HomeComponent
    }

    fun inject(homeFragment: HomeFragment)

}