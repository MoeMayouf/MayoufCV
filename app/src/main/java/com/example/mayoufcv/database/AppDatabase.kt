package com.example.mayoufcv.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mayoufcv.common.DATABASE_VERSION
import com.example.mayoufcv.data.Project

@Database(entities = [Project::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCVDao(): CVDao
}