package com.example.mayoufcv.common

import android.app.Application
import com.example.mayoufcv.di.AppComponent
import com.example.mayoufcv.di.DaggerAppComponent

class MayoufCV : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}