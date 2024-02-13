package com.estoquemga.controller.request.customerRequest

class PutCustomerRequest(
        var id: Int? = null,
        var nomeCompleto: String,
        var email: String,
        var senha: String
)