package com.estoquemga.request.notebookRequest

data class PutNotebookRequest(

    var hostname: String,

    var patrimonio: Int?,

    var serialNumber: String,

    var modelo: String,

    var situacao: String,

    var numeroChamado: String
) {


}
