package com.estoquemga.exception

class BadRequestException(override val message: String, val errorCode: String) : Exception()
