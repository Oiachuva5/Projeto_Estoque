package com.estoquemga.repository

import com.estoquemga.model.PerifericoModel
import com.estoquemga.model.SaidaPerifericoModel
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface SaidaPerifericoRepository: CrudRepository<SaidaPerifericoModel, String> {
    fun findByNomeItem (nomeItem: String): List<SaidaPerifericoModel>
}


