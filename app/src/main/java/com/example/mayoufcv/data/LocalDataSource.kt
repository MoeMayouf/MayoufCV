package com.example.mayoufcv.data

import com.example.mayoufcv.database.AppDatabase
import io.reactivex.Maybe

class LocalDataSource(private val appDatabase: AppDatabase) : DataSource {

    override fun getAllProjects() = appDatabase.getCVDao().getAllProjects()

    override fun addProject(project: Project) {
        appDatabase.getCVDao().addProject(project)
    }

}