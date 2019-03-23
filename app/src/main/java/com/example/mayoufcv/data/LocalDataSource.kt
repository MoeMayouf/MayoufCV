package com.example.mayoufcv.data

import com.example.mayoufcv.database.AppDatabase

class LocalDataSource(private val appDatabase: AppDatabase) : DataSource {

    override fun getAllProjects(isAscending: Boolean) = appDatabase.getCVDao()
        .run { if (isAscending) getAllProjectsAscending() else getAllProjectsDescending() }

    override fun addProject(project: Project) {
        appDatabase.getCVDao().addProject(project)
    }

}