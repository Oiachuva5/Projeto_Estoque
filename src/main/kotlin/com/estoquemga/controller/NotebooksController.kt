package com.estoquemga.controller

import com.estoquemga.model.NotebookModel
import com.estoquemga.extension.toNotebookModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import com.estoquemga.controller.request.notebookRequest.PostNotebookRequest
import com.estoquemga.controller.request.notebookRequest.PutNotebookRequest
import com.estoquemga.enums.NotebookStatus
import com.estoquemga.service.NotebookService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("notebooks")
class NotebooksController(
    val notebookService: NotebookService
) {
    @GetMapping("/health")
    fun teste(): String {
        return "OK :)"
    }

    @GetMapping
    fun getAll(): List<NotebookModel> {
        return notebookService.getAll()
    }

    @GetMapping("/{hostname}")
    @ResponseStatus(HttpStatus.FOUND)
    fun filterObject(@RequestParam hostname: String?) {
        notebookService.filterObject(hostname)
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid notebooks: PostNotebookRequest) {
        notebookService.create(notebooks.toNotebookModel())
    }

    @PutMapping("/{hostname}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable hostname: String, @RequestBody @Valid notebookRequest: PutNotebookRequest) {
        val notebook = NotebookModel(
            hostname = hostname,
            patrimonio = notebookRequest.patrimonio,
            serialNumber = notebookRequest.serialNumber,
            modelo = notebookRequest.modelo,
            situacao = NotebookStatus.ESTOQUE,
            numeroChamado = notebookRequest.numeroChamado
        )
        notebookService.update(notebook)
    }

    @DeleteMapping("/{hostname}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun delete(@PathVariable hostname: String) {
        notebookService.delete(hostname)
    }
}