package com.example.fitlog.data.mapper

import com.example.fitlog.data.dto.ExerciseDto
import com.example.fitlog.domain.model.Exercise

fun ExerciseDto.toDomain(): Exercise {
    return Exercise(
        name = name,
        img = imageName,
        done = false,
        set = 0,
        rep = 0,
        time = 0,
        day = "None"
    )
}
