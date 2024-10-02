package com.example.todo.entity

class Task(
    var description: String,
    var isDone: Boolean = false,
    val id: Long = 1,
)