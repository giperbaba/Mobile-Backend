package com.example.todo

import android.content.Context
import com.example.todo.interseptors.AuthorizationTokenInterceptor
import com.example.todo.mappers.TaskApiToDomainMapper
import com.example.todo.repository.TaskRepository
import com.example.todo.repository.TaskRepositoryImpl
import com.example.todo.usecases.GetTasksUseCase
import com.example.todo.usecases.GetTasksUseCaseImpl
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class AppContainer {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private fun client(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(AuthorizationTokenInterceptor())
        }.build()
    }

    private val apiUrl = "http://10.10.146.19:8090/api/todo_list/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(client())
            .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .build()
    }

    private val taskService by lazy {
        retrofit.create(TaskService::class.java)
    }

    private val repository: TaskRepository =
        TaskRepositoryImpl(taskService = taskService, apiToDomainMapper = TaskApiToDomainMapper())

    val useTask: GetTasksUseCase = GetTasksUseCaseImpl(repository)
}