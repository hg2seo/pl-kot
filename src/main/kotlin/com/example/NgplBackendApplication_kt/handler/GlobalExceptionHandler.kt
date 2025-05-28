package com.example.NgplBackendApplication_kt.handler

import com.example.NgplBackendApplication_kt.dto.response.ApiResponse
import com.example.NgplBackendApplication_kt.dto.response.Status
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@RestControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    fun unexpectedException(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        log.error("예상치 못한 오류 발생: ${ex.message}")
        log.error("발생 지점: ${ex.stackTrace.firstOrNull()}")

        val body = Status.INTERNAL_SERVER_ERROR.getBody()
        val response = ApiResponse.onFailure<Any>(
            status = body.code.toString(),
            message = body.message
        )

        return handleExceptionInternal(
            ex, response, HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR, request
        ) as ResponseEntity<Any>
    }

    @ExceptionHandler(GeneralException::class)
    fun generalException(ex: GeneralException, request: HttpServletRequest): ResponseEntity<Any> {
        val body = ex.body
        val response = ApiResponse.onFailure<Any>(
            status = body.code.toString(),
            message = body.message
        )

        val webRequest = ServletWebRequest(request)
        return handleExceptionInternal(
            ex, response, HttpHeaders.EMPTY, body.httpStatus, webRequest
        ) as ResponseEntity<Any>
    }
}