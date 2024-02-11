package com.estoquemga.extension

import com.estoquemga.model.NotebookModel
import com.estoquemga.model.PerifericoModel
import com.estoquemga.model.SaidaPerifericoModel
import com.estoquemga.request.notebookRequest.PostNotebookRequest
import com.estoquemga.request.perifericoRequest.PostPerifericoRequest
import com.estoquemga.request.notebookRequest.PutNotebookRequest
import com.estoquemga.request.perifericoRequest.PutPerifericoRequest
import com.estoquemga.request.saidaPerifericoRequest.PostSaidaPerifericoRequest

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
        nomeItem = this.nomeItem, quantidade = this.quantidade
    )
}

fun PutPerifericoRequest.toPerifericoModel(): PerifericoModel {
    return PerifericoModel(
        nomeItem = this.nomeItem, quantidade = this.quantidade
    )
}

fun PostSaidaPerifericoRequest.toSaidaPerifericoModel(): SaidaPerifericoModel {
    return SaidaPerifericoModel(
        nomeItem = this.nomeItem,
        numeroChamado = this.numeroChamado
    )

}
