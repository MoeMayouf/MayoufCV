package com.example.mayoufcv.data

import com.example.mayoufcv.net.CVService
import io.reactivex.Maybe

class RemoteDataSource(private val cvService: CVService) : DataSource {

    override fun getAllProjects() = cvService.getCV().flatMapMaybe { Maybe.just(it) }

    override fun addProject(project: Project) {
        //NO-OP
    }

}