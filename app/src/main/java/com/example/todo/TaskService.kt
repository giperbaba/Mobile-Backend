package com.example.todo;

import com.example.todo.repository.api.CreateTaskApi
import com.example.todo.repository.api.TaskApi
import com.example.todo.repository.api.UpdateTaskBody
import com.example.todo.repository.api.UpdateTaskDescriptionApi
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET;
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TaskService {

    @PUT("api/todo_list/update/desc/{id}")
    suspend fun updateTaskDescription(
        @Path("id") id: Long,
        @Body updateTaskBody: UpdateTaskDescriptionApi,
    )

    @POST("api/todo_list/create")
    suspend fun createTask(@Body createTaskApi: CreateTaskApi)

    @GET("api/todo_list")
    suspend fun getTasks(): List<TaskApi>

    @PUT("api/todo_list/update/is_done/{id}")
    suspend fun updateTaskIsDone(
        @Path("id") id: Long,
        @Body updateTaskBody: UpdateTaskBody,
    )

    @DELETE("api/todo_list/delete/{id}")
    suspend fun deleteTask(@Path("id") id: Long)

}
