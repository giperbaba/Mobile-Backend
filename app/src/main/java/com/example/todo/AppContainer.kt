package com.example.todo

import com.example.todo.mappers.TaskApiToDomainMapper
import com.example.todo.repository.TaskRepository
import com.example.todo.repository.TaskRepositoryImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class AppContainer {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8090/")
            .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }

    private val taskService by lazy {
        retrofit.create(TaskService::class.java)
    }

    val repository: TaskRepository =
        TaskRepositoryImpl(taskService = taskService, apiToDomainMapper = TaskApiToDomainMapper())

}