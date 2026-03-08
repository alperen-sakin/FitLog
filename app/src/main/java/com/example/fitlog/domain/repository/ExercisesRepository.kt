package com.example.fitlog.domain.repository

import com.example.fitlog.domain.model.Exercise
import kotlinx.coroutines.flow.Flow

interface ExercisesRepository {
    fun getExercises(): List<Exercise>

    suspend fun insertUseExercises(exercise: Exercise)
    fun getExercisesByDay(day: String): Flow<List<Exercise>>
}
