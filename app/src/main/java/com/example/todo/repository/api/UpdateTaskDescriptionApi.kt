package com.example.todo.repository.api

import kotlinx.serialization.Serializable

@Serializable
class UpdateTaskDescriptionApi(
    var newDescription: String,
)