package com.example.todo.entity

import java.util.UUID

class Task(
    var description: String,
    var isDone: Boolean = false,
    val id: UUID = UUID.randomUUID()
)