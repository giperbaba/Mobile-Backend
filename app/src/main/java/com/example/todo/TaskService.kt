package com.example.todo;

import retrofit2.http.GET;
import retrofit2.http.Query

interface TaskService {
    @GET("get")
    suspend fun getTasks(@Query("limit") limit: Int) : List<TaskApi>
}
