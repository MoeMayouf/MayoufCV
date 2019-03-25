package com.example.mayoufcv.di

import com.example.mayoufcv.screen.home.HomeActivity
import com.example.mayoufcv.screen.home.di.HomeModule
import com.example.mayoufcv.screen.home.di.HomeScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector(modules = [HomeModule::class])
    @HomeScope
    abstract fun homeActivity(): HomeActivity
}