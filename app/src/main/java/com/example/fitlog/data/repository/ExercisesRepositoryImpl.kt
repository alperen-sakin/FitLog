package com.example.fitlog.data.repository

import android.content.Context
import com.example.fitlog.data.dto.ExerciseResponseDto
import com.example.fitlog.data.local.dao.ExerciseDao
import com.example.fitlog.data.mapper.toDomain
import com.example.fitlog.data.mapper.toDomainModel
import com.example.fitlog.data.mapper.toEntity
import com.example.fitlog.domain.model.Exercise
import com.example.fitlog.domain.repository.ExercisesRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExercisesRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val exerciseDao: ExerciseDao
) : ExercisesRepository {
    override fun getExercises(): List<Exercise> {
        val jsonString =
            context.assets.open("exercises.json").bufferedReader().use { it.readText() }

        val responseDto = Gson().fromJson(jsonString, ExerciseResponseDto::class.java)

        return responseDto.exercises.map { it.toDomain() }
    }

    override suspend fun insertUseExercises(exercise: Exercise) {
        exerciseDao.insertExercises(exercise.toEntity())
    }

    override fun getExercisesByDay(day: String): Flow<List<Exercise>> {
        return exerciseDao.getExercisesByDay(day).map { entities ->
            entities.map { it.toDomainModel() }
        }
    }
}
