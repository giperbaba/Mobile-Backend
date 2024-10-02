package com.example.todo.repository.api

import kotlinx.serialization.Serializable

@Serializable
class UpdateTaskBody(
    val isDone: Boolean = false,
)