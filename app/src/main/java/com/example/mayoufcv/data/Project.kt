package com.example.mayoufcv.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mayoufcv.common.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Project(@PrimaryKey(autoGenerate = true) val id: Int? = null,
                    val company: String = "",
                   val duration: String = "",
                   val roleDescription: String = "",
                   val techStack: List<String> = emptyList(),
                   val companyLogo: String = "")