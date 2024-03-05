package com.estoquemga.repository

import com.estoquemga.model.NotebookModel
import org.springframework.data.repository.CrudRepository

interface NotebookRepository : CrudRepository<NotebookModel, String> {
    fun findByHostname(hostname: String): NotebookModel
    fun existsByHostname(hostname: String): Boolean
}
