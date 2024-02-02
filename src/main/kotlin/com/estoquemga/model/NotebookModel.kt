package com.estoquemga.model

import com.estoquemga.enums.notebookStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "notebooks")
data class NotebookModel(
    @Id var hostname: String,

    @Column var patrimonio: Int?,

    @Column var serialNumber: String,

    @Column var modelo: String,

    @Column @Enumerated var situacao: notebookStatus,

    @Column var numeroChamado: String
)

