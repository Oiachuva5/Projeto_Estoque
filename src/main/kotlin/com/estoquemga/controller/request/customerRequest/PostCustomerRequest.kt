package com.estoquemga.controller.request.customerRequest

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

class PostCustomerRequest(

    @field:NotEmpty(message = "campo nomeCompleto não pode ser nulo")
    var nomeCompleto: String,

    @field:NotEmpty
    var login: String,

    @field:NotEmpty(message = "campo e-mail não pode ser nulo")
    @field:Email(message = "E-mail invalido")
    var email: String,

    @field:NotEmpty(message = "campo senha não pode ser nulo")
    var senha: String
)