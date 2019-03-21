package com.example.mayoufcv.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mayoufcv.data.Project
import io.reactivex.Maybe

@Dao
interface CVDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addProject(project: Project)

    @Query("SELECT * FROM projects")
    fun getAllProjects(): Maybe<List<Project>>
}