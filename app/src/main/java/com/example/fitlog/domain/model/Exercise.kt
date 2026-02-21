package com.example.fitlog.domain.model

import com.example.fitlog.R

data class Exercise(
    val img: Int,
    val name: String,
    val done: Boolean,
    val set: Int,
    val rep: Int,
    val time: Int
)

object MockData {
    val exerciseList = listOf(
        Exercise(
            img = R.drawable.pushupps,
            name = "Push Up",
            done = true,
            set = 3,
            rep = 12,
            time = 0
        ),
        Exercise(
            img = R.drawable.squad,
            name = "Squat",
            done = false,
            set = 4,
            rep = 15,
            time = 0
        ),
        Exercise(
            img = R.drawable.plank,
            name = "Plank",
            done = false,
            set = 3,
            rep = 0,
            time = 60
        )
    )
}
