package com.estoquemga.repository

import com.estoquemga.model.PerifericoModel
import org.springframework.data.repository.CrudRepository

interface PerifericoRepository: CrudRepository <PerifericoModel, String> {
    fun findByNomeItem(nomeItem: String): PerifericoModel
    fun existsByNomeItem(nomeItem: String): Boolean
}