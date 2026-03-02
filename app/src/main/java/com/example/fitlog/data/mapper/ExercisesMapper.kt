package com.example.fitlog.data.mapper

import com.example.fitlog.data.dto.ExerciseDto
import com.example.fitlog.domain.model.Exercise


fun ExerciseDto.toDomain(): Exercise{
    return Exercise(
        name = name,
        img = image_name,
        done = false,
        set = 1,
        rep = 1,
        time = 1
    )
}