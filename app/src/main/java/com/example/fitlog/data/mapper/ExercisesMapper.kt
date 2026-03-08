package com.example.fitlog.data.mapper

import com.example.fitlog.data.dto.ExerciseDto
import com.example.fitlog.data.local.ExerciseEntity
import com.example.fitlog.domain.model.Exercise

fun ExerciseDto.toDomain(): Exercise {
    return Exercise(
        id = this.id,
        name = this.name,
        img = this.imageName,
        done = false,
        set = 0,
        rep = 0,
        time = 0,
        day = "None"
    )
}

fun ExerciseEntity.toDomainModel(): Exercise {
    return Exercise(
        id = this.id,

        name = this.name,
        img = this.img,
        done = this.done,
        set = this.set,
        rep = this.rep,
        time = this.time,
        day = this.day
    )
}

fun Exercise.toEntity(): ExerciseEntity {
    return ExerciseEntity(
        id = this.id,
        name = this.name,
        img = this.img,
        day = this.day,
        set = this.set,
        rep = this.rep,
        time = this.time,
        done = this.done,

    )
}
