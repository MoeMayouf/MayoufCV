package com.example.mayoufcv.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mayoufcv.data.DataSource
import java.lang.IllegalArgumentException

class HomeViewModelFactory(private val repository: DataSource) : ViewModelProvider.Factory {

   @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("The class should be an instance: " + HomeViewModel::class.java.simpleName)
    }

}