package com.example.todo.usecases

import com.example.todo.entity.Task

interface GetTasksUseCase {
    suspend operator fun invoke(): List<Task>
}