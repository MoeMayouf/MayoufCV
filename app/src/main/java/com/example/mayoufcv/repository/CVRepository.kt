package com.example.mayoufcv.repository

import com.example.mayoufcv.data.DataSource
import com.example.mayoufcv.data.Project

class CVRepository(
    private val localDataSource: DataSource,
    private val remoteDataSource: DataSource) : DataSource {

    override fun getAllProjects(isAscending: Boolean) = getRemoteData(isAscending)
        .onErrorResumeNext { _: Throwable -> localDataSource.getAllProjects(isAscending) }

    private fun getRemoteData(isAscending: Boolean) = remoteDataSource.getAllProjects(isAscending)
            .doOnSuccess {
                deleteAllProjects()
                it.forEach(this::addProject) }


    override fun addProject(project: Project) {
        localDataSource.addProject(project)
    }

    override fun deleteAllProjects() {
        localDataSource.deleteAllProjects()
    }

}