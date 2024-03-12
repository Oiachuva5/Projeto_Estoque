package com.estoquemga.service

import com.estoquemga.controller.request.customerRequest.PutCustomerRequest
import com.estoquemga.enums.CustomerStatus
import com.estoquemga.enums.Errors
import com.estoquemga.exception.BadRequestException
import com.estoquemga.exception.NotFoundException
import com.estoquemga.model.CustomerModel
import com.estoquemga.repository.CustomerRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
@Transactional
class CustomerService(private val repository: CustomerRepository) {


    fun getAll(): List<CustomerModel> {
        return repository.findAll().toList()
    }

    fun getObject(id: Int): CustomerModel {
        return repository.findById(id).orElseThrow { NotFoundException(Errors.CE001.message, Errors.CE001.code) }
    }

    fun create(customer: CustomerModel) {
        repository.save(customer)
    }

    fun update(customer: PutCustomerRequest, id: Int) {
        if (!repository.existsById(id!!))
            throw BadRequestException(
                Errors.CE001.message,
                Errors.CE001.code
            )

        val customerQuery: CustomerModel = repository.findById(id!!).get()
        val customerSave = CustomerModel(
            id = customerQuery.id,
            nomeCompleto = customer.nomeCompleto,
            login = customerQuery.login,
            email = customer.email,
            senha = customer.senha,
            status = customerQuery.status
        )
        repository.save(customerSave)
    }

    fun delete(id: Int) {

        val customer = repository.findById(id).orElseThrow {
            NotFoundException(
                Errors.CE001.message,
                Errors.CE001.code
            )
        }
        customer.status = CustomerStatus.INATIVO
        repository.save(customer)
    }
}