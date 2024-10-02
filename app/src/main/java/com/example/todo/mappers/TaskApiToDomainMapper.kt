package com.example.todo.mappers

import com.example.todo.entity.Task
import com.example.todo.TaskApi

internal class TaskApiToDomainMapper : (TaskApi) -> Task {

    override fun invoke(from: TaskApi): Task {
        return Task(
            description = from.description,
            isDone = from.isDone,
        )
    }
}