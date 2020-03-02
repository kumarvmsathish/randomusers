package com.infinite.randomusers.di

import com.infinite.randomusers.ui.fragment.HomeFragment
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule constructor(val homeFragment: HomeFragment) {


    @Provides
    @HomeScope
    fun provideHomeFragment(): HomeFragment {
        return homeFragment
    }



}