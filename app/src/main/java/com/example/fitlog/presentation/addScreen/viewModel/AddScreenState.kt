package com.example.fitlog.presentation.addScreen.viewModel

import com.example.fitlog.domain.model.Exercise

data class AddScreenState(
    val exercises: List<Exercise> = emptyList(),

)
