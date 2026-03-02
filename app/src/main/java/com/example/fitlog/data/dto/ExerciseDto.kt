package com.example.fitlog.data.dto


data class ExerciseResponseDto(
    val exercises: List<ExerciseDto>
)
data class ExerciseDto(
    val id: Int,
    val name: String,
    val image_name: String
)
