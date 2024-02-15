package com.estoquemga.controller.request.saidaPerifericoRequest

import jakarta.validation.constraints.NotEmpty


data class PostSaidaPerifericoRequest(

    @field:NotEmpty(message = "o campo nomeItem não pode ser nulo")
    var nomeItem: String,

    @field:NotEmpty(message = "o campo numeroChamado não pode ser nulo")
    var numeroChamado: String
)
