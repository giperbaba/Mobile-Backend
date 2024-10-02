package com.example.todo.usecases

import com.example.todo.entity.Task
import com.example.todo.repository.TaskRepository

class GetTasksUseCaseImpl(private val repository: TaskRepository) : GetTasksUseCase {
    override suspend fun invoke(): List<Task> = repository.getTasks()
}