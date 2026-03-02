package com.example.fitlog.domain.model

import com.example.fitlog.R

data class Exercise(
    val img: String,
    val name: String,
    val done: Boolean,
    val set: Int,
    val rep: Int,
    val time: Int
)


