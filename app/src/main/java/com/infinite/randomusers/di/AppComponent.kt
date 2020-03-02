package com.infinite.randomusers.di

import android.app.Application
import com.infinite.randomusers.network.NetworkModule
import com.infinite.randomusers.ui.fragment.HomeFragment
import com.infinite.randomusers.ui.fragment.UserDetailFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppSubComponents::class])
interface AppComponent {


    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph for di injection
        fun create(@BindsInstance networkModule: NetworkModule): AppComponent
    }

    fun homeComponent(): HomeComponent.Builder
    fun userDataComponent(): UserComponent.Builder


}