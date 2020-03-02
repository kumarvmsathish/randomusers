package com.infinite.randomusers.application

import android.app.Application
import com.infinite.randomusers.di.AppComponent
import com.infinite.randomusers.di.DaggerAppComponent
import com.infinite.randomusers.network.NetworkModule

class RandomUserApplication: Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    /**
     * Method helps in testing the application. Override this method to provide app component for testing
     * Keeping it open modifier, since under testing we will use it
     */
    open fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(NetworkModule())
    }

}