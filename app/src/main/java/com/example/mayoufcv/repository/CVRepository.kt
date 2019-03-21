package com.example.mayoufcv.repository

import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.data.Project

class CVRepository(
    private val localDataSource: DataSource,
    private val remoteDataSource: DataSource) : DataSource {

    override fun getAllProjects() = remoteDataSource.getAllProjects()
        .doOnSuccess { it.forEach(this::addProject) }
        .onErrorResumeNext { _: Throwable -> localDataSource.getAllProjects() }

    override fun addProject(project: Project) {
        localDataSource.addProject(project)
    }

}