package com.example.mayoufcv.di

import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.repository.CVRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Repository
    @Singleton
    fun provideRepository(@Local localDataSource: DataSource, @Remote remoteDataSource: DataSource): DataSource {
        return CVRepository(localDataSource = localDataSource, remoteDataSource = remoteDataSource)
    }
}