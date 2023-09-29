package com.example.borutoapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val info: Info? = null,
    val results: List<Hero> = emptyList(),
)
