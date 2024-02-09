package com.estoquemga.request.notebookRequest

import com.estoquemga.enums.NotebookStatus

data class PutNotebookRequest(

    var hostname: String,

    var patrimonio: Int?,

    var serialNumber: String,

    var modelo: String,

    var situacao: NotebookStatus,

    var numeroChamado: String
)
