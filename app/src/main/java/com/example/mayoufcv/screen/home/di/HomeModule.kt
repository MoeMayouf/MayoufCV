package com.example.mayoufcv.screen.home.di

import androidx.lifecycle.ViewModelProviders
import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.di.Repository
import com.example.mayoufcv.screen.home.HomeActivity
import com.example.mayoufcv.screen.home.HomeViewModel
import com.example.mayoufcv.screen.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    @HomeScope
    fun provideHomeViewModelFactory(@Repository repository: DataSource)
        = HomeViewModelFactory(repository)

    @Provides
    @HomeScope
    fun provideHomeViewModel(homeViewModelFactory: HomeViewModelFactory, homeActivity: HomeActivity)
        = ViewModelProviders.of(homeActivity, homeViewModelFactory).get(HomeViewModel::class.java)
}