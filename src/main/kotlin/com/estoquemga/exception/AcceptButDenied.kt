package com.estoquemga.exception

class AcceptButDenied(override val message: String, val errorCode: String) : Exception()