package com.example.todo

import kotlinx.serialization.Serializable

@Serializable
class TaskApi (
    val id: Long,
    val description: String,
    val isDone: Boolean
)