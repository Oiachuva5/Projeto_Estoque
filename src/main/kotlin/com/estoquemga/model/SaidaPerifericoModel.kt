package com.estoquemga.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "SaidaPeriferico")
data class SaidaPerifericoModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = null,

    @Column var nomeItem: String,

    @Column var numeroChamado: String
) {}