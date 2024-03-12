package com.estoquemga.helper

import com.estoquemga.enums.CustomerStatus
import com.estoquemga.model.CustomerModel
import java.util.*

fun buildCustomer(
    id: Int? = null,
    nomeCompleto: String = "customer name",
    login: String = "login${UUID.randomUUID()}",
    email: String = "${UUID.randomUUID()}@email.com",
    senha: String = "password",
    status: CustomerStatus = CustomerStatus.ATIVO
): CustomerModel = CustomerModel(
    id = id,
    nomeCompleto = nomeCompleto,
    login = login,
    email = email,
    senha = senha,
    status = status
)
