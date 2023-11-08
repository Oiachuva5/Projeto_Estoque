package com.estoquemga.service

import com.estoquemga.model.NotebookModel
import com.estoquemga.repository.NotebookRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

import java.lang.Exception

@Service
@Transactional
class NotebookService(private val repository: NotebookRepository) {

    fun getAll(hostname: String?): List<NotebookModel> {
        hostname?.let {
            return repository.findByHostname(hostname)
        }
        return repository.findAll().toList()
    }

    fun create(notebook: NotebookModel) {
        repository.save(notebook)
    }

    fun filterObject(hostname: String?): List<NotebookModel> {
        hostname?.let {
            return repository.findByHostname(hostname)
        }
        return repository.findAll().toList()
    }

    fun update(notebook: NotebookModel) {
        if (!repository.existsByHostname(notebook.hostname)) {
            throw Exception()
        }
        repository.save(notebook)
    }

    fun delete(hostname: String){
        if (!repository.existsByHostname(hostname)){
            throw Exception()
        }
        repository.deleteByHostname(hostname)
    }
}

