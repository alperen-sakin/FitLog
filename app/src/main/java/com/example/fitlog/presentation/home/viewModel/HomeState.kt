package com.example.fitlog.presentation.home.viewModel

import com.example.fitlog.domain.model.Days
import com.example.fitlog.domain.model.Exercise

data class HomeState(
    val selectedDay: Days = Days.Mon,
    val exercises: List<Exercise> = emptyList(),

) {
    val totalExercise: Int get() = exercises.size
    val completedExercise: Int get() = exercises.count { it.done }

    val currentProgress: Float get() = completedExercise.toFloat() / totalExercise.toFloat()
    val leftExercise: Int get() = totalExercise - completedExercise
}
