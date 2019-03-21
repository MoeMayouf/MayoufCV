package com.example.mayoufcv.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mayoufcv.common.TABLE_NAME
import com.example.mayoufcv.database.StringListConverter

@Entity(tableName = TABLE_NAME)
@TypeConverters(StringListConverter::class)
data class Project(@PrimaryKey(autoGenerate = true) val id: Int? = null,
                    val company: String = "",
                   val duration: String = "",
                   val roleDescription: String = "",
                   val techStack: List<String> = emptyList(),
                   val companyLogo: String = "")