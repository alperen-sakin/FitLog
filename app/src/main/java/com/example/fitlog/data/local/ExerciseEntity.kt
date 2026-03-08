package com.example.fitlog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val img: String,
    val done: Boolean,
    val set: Int,
    val rep: Int,
    val time: Int,
    val day: String
)
