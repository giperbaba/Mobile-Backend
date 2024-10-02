package com.example.todo.repository

import com.example.todo.entity.Task
import com.example.todo.TaskService
import com.example.todo.mappers.TaskApiToDomainMapper

internal class TaskRepositoryImpl(
    private val taskService: TaskService,
    private val apiToDomainMapper: TaskApiToDomainMapper,
) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return taskService.getTasks(100).map(apiToDomainMapper)
    }
}