package com.estoquemga.service

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

    fun getAll(nomeItem: String?): List<PerifericoModel> {
        nomeItem?.let{
            return perifericoRepository.findByNomeItem(nomeItem)
        }
        return perifericoRepository.findAll().toList()
    }
    // Saída Periféricos

    fun retiradaPeriferico(saidaPeriferico: SaidaPerifericoModel){
        saidaPerifericosRepository.save(saidaPeriferico)
    }

    fun todasRetiradas(nomeItem: String?): List<SaidaPerifericoModel>{
        nomeItem?.let {
            return saidaPerifericosRepository.findByNomeItem(nomeItem)
        }
        return saidaPerifericosRepository.findAll().toList()
    }
}



