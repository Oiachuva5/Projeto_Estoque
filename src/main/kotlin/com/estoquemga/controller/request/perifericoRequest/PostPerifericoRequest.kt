package com.estoquemga.controller.request.perifericoRequest

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class PostPerifericoRequest(
    @field:NotEmpty(message = "o campo nomeItem não pode ser nulo")
    var nomeItem: String,

    @field:NotNull(message = "a quantidade não pode ser nula")
    var quantidade: Int
) {

}
