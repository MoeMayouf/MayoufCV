package com.example.mayoufcv.screen.home.di

import com.example.mayoufcv.screen.home.HomeActivity
import dagger.Binds
import dagger.Module

@Module
abstract class HomeActivityModule {
    @Binds
    @HomeScope
    abstract fun homeActivity(homeActivity: HomeActivity): HomeActivity
}