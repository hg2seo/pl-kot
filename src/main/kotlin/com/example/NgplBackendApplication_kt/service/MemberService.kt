package com.example.NgplBackendApplication_kt.service

import com.example.NgplBackendApplication_kt.dto.PasswordValidateRequest
import com.example.NgplBackendApplication_kt.dto.response.Status
import com.example.NgplBackendApplication_kt.handler.GeneralException
import org.springframework.stereotype.Service

@Service
class MemberService {

    companion object {
        private const val PWD_MIN_LENGTH = 8
        private const val PWD_MAX_LENGTH = 16
    }

    fun validatePassword(req: PasswordValidateRequest): Boolean {
        val pwd = req.password
        val confirm = req.confirmPassword

        if (pwd.isBlank() || confirm.isBlank())
            throw GeneralException(Status.BAD_REQUEST_ARGUMENT)

        if (pwd.length !in PWD_MIN_LENGTH..PWD_MAX_LENGTH)
            return false

        return pwd == confirm
    }
}