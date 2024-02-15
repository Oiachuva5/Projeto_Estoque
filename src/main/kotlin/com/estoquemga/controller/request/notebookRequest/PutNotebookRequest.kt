package com.estoquemga.controller.request.notebookRequest

import jakarta.validation.constraints.NotEmpty

data class PutNotebookRequest(

    @field:NotEmpty(message = "o campo hostname não pode ser nulo")
    var hostname: String,

    var patrimonio: Int?,

    @field:NotEmpty(message ="o campo serialNumber não pode ser nulo" )
    var serialNumber: String,

    @field:NotEmpty(message ="o campo serialNumber não pode ser nulo" )
    var modelo: String,

    @field:NotEmpty
    var numeroChamado: String
)
