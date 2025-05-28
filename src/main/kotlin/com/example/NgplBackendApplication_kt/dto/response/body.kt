package com.example.NgplBackendApplication_kt.dto.response


import org.springframework.http.HttpStatus

data class Body(
    val code: Int,
    val message: String,
    val httpStatus: HttpStatus
)