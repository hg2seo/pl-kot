package com.example.NgplBackendApplication_kt.dto.response

import org.springframework.http.HttpStatus

enum class Status(
    val code: Int,
    val message: String,
    val httpStatus: HttpStatus
) {
    OK(200, "요청이 성공적으로 처리되었습니다.", HttpStatus.OK),
    BAD_REQUEST(400, "요청의 Request Body가 필요합니다.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ARGUMENT(400, "요청 내용이 잘못되었습니다.", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(500, "서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);

    fun getBody(): Body = Body(code, message, httpStatus)
}