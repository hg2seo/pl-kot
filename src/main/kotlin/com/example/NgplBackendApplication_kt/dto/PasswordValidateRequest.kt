package com.example.NgplBackendApplication_kt.dto

data class PasswordValidateRequest(
    val password: String,
    val confirmPassword: String
)