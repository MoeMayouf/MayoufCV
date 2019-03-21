package com.example.mayoufcv.data

import io.reactivex.Maybe

interface DataSource {
    fun getAllProjects(): Maybe<List<Project>>
    fun addProject(project: Project)
}