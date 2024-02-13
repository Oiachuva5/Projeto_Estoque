package com.estoquemga.extension

import com.estoquemga.controller.request.customerRequest.PostCustomerRequest
import com.estoquemga.controller.request.customerRequest.PutCustomerRequest
import com.estoquemga.model.NotebookModel
import com.estoquemga.model.PerifericoModel
import com.estoquemga.model.SaidaPerifericoModel
import com.estoquemga.controller.request.notebookRequest.PostNotebookRequest
import com.estoquemga.controller.request.perifericoRequest.PostPerifericoRequest
import com.estoquemga.controller.request.notebookRequest.PutNotebookRequest
import com.estoquemga.controller.request.perifericoRequest.PutPerifericoRequest
import com.estoquemga.controller.request.saidaPerifericoRequest.PostSaidaPerifericoRequest
import com.estoquemga.enums.CustomerStatus
import com.estoquemga.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
            nomeCompleto = this.nomeCompleto,
            login = this.login,
            email = this.email,
            senha = this.senha,
            status = CustomerStatus.ATIVO
    )
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
            nomeCompleto = this.nomeCompleto,
            login = previousValue.login,
            email = this.email,
            senha = this.senha,
            status = previousValue.status

    )
}

fun PostNotebookRequest.toNotebookModel(): NotebookModel {
    return NotebookModel(
            hostname = this.hostname,
            patrimonio = this.patrimonio,
            serialNumber = this.serialNumber,
            modelo = this.modelo,
            situacao = this.situacao,
            numeroChamado = this.numeroChamado
    )
}

fun PutNotebookRequest.toNotebookModel(hostname: String): NotebookModel {
    return NotebookModel(
            hostname = this.hostname,
            patrimonio = this.patrimonio,
            serialNumber = this.serialNumber,
            modelo = this.modelo,
            situacao = this.situacao,
            numeroChamado = this.numeroChamado
    )
}

fun PostPerifericoRequest.toPerifericoModel(): PerifericoModel {
    return PerifericoModel(
            nomeItem = this.nomeItem,
            quantidade = this.quantidade
    )
}

fun PutPerifericoRequest.toPerifericoModel(): PerifericoModel {
    return PerifericoModel(
            nomeItem = this.nomeItem,
            quantidade = this.quantidade
    )
}

fun PostSaidaPerifericoRequest.toSaidaPerifericoModel(): SaidaPerifericoModel {
    return SaidaPerifericoModel(
            nomeItem = this.nomeItem,
            numeroChamado = this.numeroChamado
    )

}
