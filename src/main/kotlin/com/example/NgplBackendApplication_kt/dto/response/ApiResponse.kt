package com.example.NgplBackendApplication_kt.dto.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("success", "status", "message", "data")
data class ApiResponse<T>(
    val isSuccess: Boolean,
    val status: String,
    val message: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val data: T? = null
) {
    companion object {
        fun <T> success(status: String, message: String, data: T? = null): ApiResponse<T> =
            ApiResponse(true, status, message, data)

        fun <T> onFailure(status: String, message: String, data: T? = null): ApiResponse<T> =
            ApiResponse(false, status, message, data)
    }
}