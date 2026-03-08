package com.example.fitlog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitlog.data.local.dao.ExerciseDao

@Database(entities = [ExerciseEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
}
