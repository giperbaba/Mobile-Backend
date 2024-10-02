package com.example.todo.repository

import com.example.todo.entity.Task

interface TaskRepository {
    suspend fun getTasks(): List<Task>
}