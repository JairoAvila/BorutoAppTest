package com.example.borutoapp.util

fun String.extractPageNumber(): Int? {
    val queryParameters = this.split("?").getOrNull(1)?.split("&")
    val pageParameter = queryParameters?.find { it.startsWith("page=") }
    return pageParameter?.substringAfter("page=")?.toIntOrNull()
}