package com.estoquemga.model

import com.estoquemga.enums.CustomerStatus
import jakarta.persistence.*

@Entity(name="customer")
class CustomerModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int? = null,

    @Column var nomeCompleto: String,

    @Column var login: String,

    @Column var email: String,

    @Column var senha: String,

    @Column @Enumerated(EnumType.STRING) var status: CustomerStatus
)