package com.estoquemga.controller

import com.estoquemga.extension.toPerifericoModel
import com.estoquemga.extension.toSaidaPerifericoModel
import com.estoquemga.model.PerifericoModel
import com.estoquemga.request.perifericoRequest.PostPerifericoRequest
import com.estoquemga.request.saidaPerifericoRequest.PostSaidaPerifericoRequest
import com.estoquemga.service.PerifericoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("periferico")
class PerifericoController(
    private val perifericoService: PerifericoService
) {
    @GetMapping("/teste")
    fun teste(): String {
        return "teste periferico"
    }

    fun getAll(nomeItem: String?): List<PerifericoModel> {
        return perifericoService.getAll(nomeItem)
    }

    @PostMapping("/cadastrar")
    fun create(@RequestBody periferico: PostPerifericoRequest) {
        perifericoService.create(periferico.toPerifericoModel())
    }

//    @PostMapping("/saida")
//    fun retiradaPeriferico(@RequestBody saidaPeriferico: PostSaidaPerifericoRequest) {
//        perifericoService.retiradaPeriferico(saidaPeriferico.toSaidaPerifericoModel())
//    }

}