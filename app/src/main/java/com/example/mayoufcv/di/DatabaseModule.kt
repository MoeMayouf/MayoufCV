package com.example.mayoufcv.di

import android.app.Application
import androidx.room.Room
import com.example.mayoufcv.common.DATABASE_NAME
import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.data.LocalDataSource
import com.example.mayoufcv.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application) =
        Room.databaseBuilder(application, AppDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @Local
    @Singleton
    fun provideLocalDataSource(appDatabase: AppDatabase): DataSource = LocalDataSource(appDatabase)
}