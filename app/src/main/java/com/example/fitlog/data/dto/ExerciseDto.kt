package com.example.fitlog.data.dto

import com.google.gson.annotations.SerializedName

data class ExerciseResponseDto(
    val exercises: List<ExerciseDto>
)
data class ExerciseDto(
    val id: Int,
    val name: String,
    @SerializedName("image_name")
    val imageName: String
)
