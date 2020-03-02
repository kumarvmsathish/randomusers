package com.infinite.randomusers.di

import com.infinite.randomusers.interfaces.IListItemClickListener
import com.infinite.randomusers.ui.fragment.HomeFragment
import dagger.Module
import dagger.Provides

@Module(includes = [HomeFragmentModule::class])
class ListItemClickModule{


    @Provides
    @HomeScope
    fun provideListItemClickListener(homeFragment: HomeFragment): IListItemClickListener{
        return homeFragment
    }

}