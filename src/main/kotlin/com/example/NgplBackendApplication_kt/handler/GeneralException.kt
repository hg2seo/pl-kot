package com.example.NgplBackendApplication_kt.handler

import com.example.NgplBackendApplication_kt.dto.response.Body
import com.example.NgplBackendApplication_kt.dto.response.Status

class GeneralException(
    val body: Body
) : RuntimeException(body.message) {
    constructor(status: Status) : this(status.getBody())
}