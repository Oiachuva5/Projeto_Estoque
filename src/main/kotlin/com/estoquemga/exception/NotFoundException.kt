package com.estoquemga.exception

class NotFoundException(override val message: String, val errorCode: String): Exception()