package com.example.fitlog.presentation.home.viewModel

import com.example.fitlog.domain.model.Days

data class HomeState(
    val selectedDay: Days = Days.Mon,
    val totalExercise: Int = 100,
    val completedExercise: Int = 5,

)
