package com.example.mayoufcv.net

import com.example.mayoufcv.common.PROJECTS_ENDPOINT
import com.example.mayoufcv.data.Project
import io.reactivex.Single
import retrofit2.http.GET

interface CVService {
    @GET(PROJECTS_ENDPOINT)
    fun getCV(): Single<List<Project>>
}