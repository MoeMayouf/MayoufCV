package com.example.mayoufcv.data

import io.reactivex.Maybe

interface DataSource {
    fun getAllProjects(isAscending: Boolean): Maybe<List<Project>>
    fun addProject(project: Project)
    fun deleteAllProjects()
}