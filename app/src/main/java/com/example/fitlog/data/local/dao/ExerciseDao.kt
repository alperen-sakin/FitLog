package com.example.fitlog.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fitlog.data.local.ExerciseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(exercises: ExerciseEntity)

    @Query("SELECT * FROM exercises WHERE day = :day")
    fun getExercisesByDay(day: String): Flow<List<ExerciseEntity>>

    @Delete
    suspend fun deleteExercise(exercise: ExerciseEntity)

    @Update
    suspend fun updateExercise(exercise: ExerciseEntity)
}
