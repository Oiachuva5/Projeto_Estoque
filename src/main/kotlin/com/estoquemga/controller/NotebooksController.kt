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
    @GetMapping("/teste")
    fun teste(): String {
        return "olá"
    }

    @GetMapping
    fun getAll(hostname: String?): List<NotebookModel> {
        return notebookService.getAll(hostname)
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid notebooks: PostNotebookRequest) {
        notebookService.create(notebooks.toNotebookModel())
    }

    @GetMapping("/{hostname}")
    @ResponseStatus(HttpStatus.FOUND)
    fun filterObject(@RequestParam hostname: String?) {
        notebookService.filterObject(hostname)
    }

    @PutMapping("/{hostname}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable hostname: String, @RequestBody @Valid notebooks: PutNotebookRequest) {
        notebookService.update(notebooks.toNotebookModel(hostname))
    }

    @DeleteMapping("/{hostname}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun delete(@PathVariable hostname: String) {
        notebookService.delete(hostname)
    }
}