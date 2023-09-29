package com.example.borutoapp.data.remote

import com.example.borutoapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {

    @GET("/api/character")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/api/character")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}