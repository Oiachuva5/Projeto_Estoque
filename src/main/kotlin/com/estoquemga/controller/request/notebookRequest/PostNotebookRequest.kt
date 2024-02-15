package com.estoquemga.controller.request.notebookRequest

import jakarta.validation.constraints.NotEmpty

data class PostNotebookRequest(

    @field:NotEmpty(message = "o campo hostname não pode ser nulo")
    var hostname: String,

    var patrimonio: Int?,

    @field:NotEmpty(message = "o campo serialnumber não pode ser nulo")
    var serialNumber: String,

    @field:NotEmpty(message = "o campo modelo não pode ser nulo")
    var modelo: String,

)