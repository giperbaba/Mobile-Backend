package com.example.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.repository.api.CreateTaskApi
import com.example.todo.entity.Task
import com.example.todo.repository.TaskRepository
import com.example.todo.repository.api.UpdateTaskBody
import com.example.todo.repository.api.UpdateTaskDescriptionApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    init {
        getAllTasks()
    }

    val tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())

    fun addTask(description: String, isDone: Boolean) {
        viewModelScope.launch {
            repository.createTask(
                CreateTaskApi(
                    description = description,
                    isDone = isDone,
                )
            )
            getAllTasks()
        }
    }

    fun updateTaskBody(id: Long, updateTaskBody: UpdateTaskBody) {
        viewModelScope.launch {
            repository.updateTask(id, updateTaskBody)
        }
    }

    fun updateTask(updatedTask: Task) {
        viewModelScope.launch {
            repository.updateTaskDescription(
                updatedTask.id,
                UpdateTaskDescriptionApi(updatedTask.description)
            )
            getAllTasks()
        }
    }

    fun removeTask(id: Long) {
        viewModelScope.launch {
            repository.deleteTask(id)
            getAllTasks()
        }
    }

    fun setTasks(newTasks: List<Task>) {
        tasks.update { newTasks.toMutableList() }
    }

    private fun getAllTasks() {
        viewModelScope.launch {
            val taskList = repository.getTasks()
            tasks.emit(taskList.toMutableList())
        }
    }
}