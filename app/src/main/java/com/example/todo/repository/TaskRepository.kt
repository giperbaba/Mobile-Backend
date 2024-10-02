package com.example.todo.repository

import com.example.todo.repository.api.CreateTaskApi
import com.example.todo.entity.Task
import com.example.todo.repository.api.UpdateTaskBody
import com.example.todo.repository.api.UpdateTaskDescriptionApi

interface TaskRepository {
    suspend fun getTasks(): List<Task>

    suspend fun updateTask(id: Long, updateTaskBody: UpdateTaskBody)

    suspend fun deleteTask(id: Long)

    suspend fun createTask(createTaskBody: CreateTaskApi)

    suspend fun updateTaskDescription(
        id: Long,
        updateTaskDescriptionApi: UpdateTaskDescriptionApi
    )
}