package com.example.mayoufcv.di

import android.app.Application
import com.example.mayoufcv.common.API_TIMEOUT_SECONDS
import com.example.mayoufcv.common.BASE_URL
import com.example.mayoufcv.common.CACHE_SIZE
import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.data.RemoteDataSource
import com.example.mayoufcv.net.CVService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.annotations.NotNull
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCache(application: Application) = Cache(application.cacheDir, CACHE_SIZE)

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @NotNull
    fun provideCVService(retrofit: Retrofit) = retrofit.create(CVService::class.java)

    @Provides
    @Remote
    @Singleton
    fun provideRemoteDataSource(cvService: CVService): DataSource = RemoteDataSource(cvService)
}