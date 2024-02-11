package com.estoquemga.service

import com.estoquemga.enums.Errors
import com.estoquemga.exception.BadRequestException
import com.estoquemga.model.PerifericoModel
import com.estoquemga.model.SaidaPerifericoModel
import com.estoquemga.repository.PerifericoRepository
import com.estoquemga.repository.SaidaPerifericoRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Transactional
class PerifericoService() {
    //Entrada Periféricos
    @Autowired
    lateinit var saidaPerifericosRepository: SaidaPerifericoRepository
    @Autowired
    lateinit var perifericoRepository: PerifericoRepository
    fun create(periferico: PerifericoModel){
        perifericoRepository.save(periferico)

    }

    fun getAll(): List<PerifericoModel> {
        return perifericoRepository.findAll().toList()
    }

    fun retiradaPeriferico(saidaPeriferico: SaidaPerifericoModel){

        val existsPeripheral:Boolean = perifericoRepository.existsByNomeItem(saidaPeriferico.nomeItem)
        if (!existsPeripheral)
            throw BadRequestException(
                Errors.PE001.message,
                Errors.PE001.code
            )

        val amountItem = perifericoRepository.findByNomeItem(saidaPeriferico.nomeItem)
        if(amountItem.quantidade <= 0)
            throw BadRequestException(
                Errors.PE002.message,
                Errors.PE002.code
            )

        amountItem.quantidade -= 1
        perifericoRepository.save(amountItem)
        saidaPerifericosRepository.save(saidaPeriferico)
    }

    fun todasRetiradas(): List<SaidaPerifericoModel>{
        return saidaPerifericosRepository.findAll().toList()
    }
}



