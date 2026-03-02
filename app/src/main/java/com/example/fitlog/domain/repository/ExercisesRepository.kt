package com.example.fitlog.domain.repository

import com.example.fitlog.domain.model.Exercise

interface ExercisesRepository {
    fun getExercises(): List<Exercise>
}

