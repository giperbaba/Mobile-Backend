package com.example.todo.repository.api

import kotlinx.serialization.Serializable

@Serializable
class CreateTaskApi(
    var description: String,
    var isDone: Boolean,
)