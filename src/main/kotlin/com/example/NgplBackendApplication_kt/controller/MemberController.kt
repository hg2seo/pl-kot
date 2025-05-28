package com.example.NgplBackendApplication_kt.controller

import com.example.NgplBackendApplication_kt.dto.PasswordValidateRequest
import com.example.NgplBackendApplication_kt.dto.response.ApiResponse
import com.example.NgplBackendApplication_kt.dto.response.Status
import com.example.NgplBackendApplication_kt.handler.GeneralException
import com.example.NgplBackendApplication_kt.service.MemberService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/test")
    fun test(): ApiResponse<Any?> {
        return ApiResponse.success(
            status = Status.OK.code.toString(),
            message = Status.OK.message,
            data = null
        )
    }

    @PostMapping("/validate_password")
    fun checkPasswordValidation(@RequestBody req: PasswordValidateRequest?): ApiResponse<Boolean> {
        if (req == null) throw GeneralException(Status.BAD_REQUEST)

        val isValidate = memberService.validatePassword(req)
        return ApiResponse.success(
            status = Status.OK.code.toString(),
            message = Status.OK.message,
            data = isValidate
        )
    }
}