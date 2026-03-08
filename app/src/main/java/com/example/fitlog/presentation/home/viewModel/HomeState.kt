package com.example.fitlog.presentation.home.viewModel

import com.example.fitlog.domain.model.Days
import com.example.fitlog.domain.model.Exercise

data class HomeState(
    val selectedDay: Days = Days.Mon,
    val exercises: List<Exercise> = emptyList(),

) {
    val totalExercise: Int get() = exercises.size
    val completedExercise: Int get() = exercises.count { it.done }
    val leftExercise: Int get() = totalExercise - completedExercise

    val currentProgress: Float get() = if (totalExercise > 0) {
        completedExercise.toFloat() / totalExercise.toFloat()
    } else {
        0f
    }
}
