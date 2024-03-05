package com.estoquemga.service

import com.estoquemga.enums.Errors
import com.estoquemga.enums.NotebookStatus
import com.estoquemga.exception.NotFoundException
import com.estoquemga.model.NotebookModel
import com.estoquemga.repository.NotebookRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class NotebookService(private val repository: NotebookRepository) {

    fun getAll(): List<NotebookModel> {
        return repository.findAll().toList()
    }

    fun filterObject(hostname: String?): NotebookModel {
        hostname?.let {
            return repository.findByHostname(hostname)
        }
        throw NotFoundException(Errors.NE001.message, Errors.NE001.code)
    }

    fun create(notebook: NotebookModel) {
        repository.save(notebook)
    }

    fun update(notebook: NotebookModel) {
        if (!repository.existsByHostname(notebook.hostname))
            throw NotFoundException(Errors.NE001.message, Errors.NE001.code)

        val actualStatusNotebook: NotebookModel = repository.findByHostname(notebook.hostname)
        notebook.situacao = actualStatusNotebook.situacao
        repository.save(notebook)
    }

    fun delete(hostname: String) {
        if (!repository.existsByHostname(hostname)) {
            throw NotFoundException(Errors.NE001.message, Errors.NE001.code)
        }

        val getNotebook: NotebookModel = repository.findByHostname(hostname)
        getNotebook.situacao = NotebookStatus.DELETADO
        repository.save(getNotebook)
    }
}

