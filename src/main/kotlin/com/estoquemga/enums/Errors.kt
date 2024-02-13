package com.estoquemga.enums

enum class Errors(val code: String, val message: String) {
    //Generic
    OPE001("OPE-001", "Invalid Request"),

    //Customer
    CE001("CE-001", "Customer não existe"),
    //Notebook

    //Periferico
    PE001("PE-001", "Item não existe"),
    PE002("PE-002", "Quantidade insuficiente no estoque")
}