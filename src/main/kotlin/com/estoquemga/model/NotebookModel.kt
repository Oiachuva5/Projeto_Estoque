package com.estoquemga.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "notebooks")
data class NotebookModel(
    @Id var hostname: String,

    @Column var patrimonio: Int?,

    @Column var serialNumber: String,

    @Column var modelo: String,

    @Column var situacao: String,

    @Column var numeroChamado: String
) {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

}

