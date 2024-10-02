package com.example.todo.repository

import com.example.todo.entity.Task
import com.example.todo.TaskService
import com.example.todo.repository.api.CreateTaskApi
import com.example.todo.mappers.TaskApiToDomainMapper
import com.example.todo.repository.api.UpdateTaskBody
import com.example.todo.repository.api.UpdateTaskDescriptionApi

internal class TaskRepositoryImpl(
    private val taskService: TaskService,
    private val apiToDomainMapper: TaskApiToDomainMapper,
) : TaskRepository {

    override suspend fun getTasks(): List<Task> {
        return taskService.getTasks().map(apiToDomainMapper)
    }

    override suspend fun updateTask(id: Long, updateTaskBody: UpdateTaskBody) {
        return taskService.updateTaskIsDone(id, updateTaskBody)
    }

    override suspend fun deleteTask(id: Long) {
        taskService.deleteTask(id)
    }

    override suspend fun createTask(createTaskBody: CreateTaskApi) {
        taskService.createTask(createTaskBody)
    }

    override suspend fun updateTaskDescription(
        id: Long,
        updateTaskDescriptionApi: UpdateTaskDescriptionApi
    ) {
        taskService.updateTaskDescription(id, updateTaskDescriptionApi)
    }

}