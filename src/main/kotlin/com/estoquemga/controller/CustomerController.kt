package com.estoquemga.controller

import com.estoquemga.controller.request.customerRequest.PostCustomerRequest
import com.estoquemga.controller.request.customerRequest.PutCustomerRequest
import com.estoquemga.extension.toCustomerModel
import com.estoquemga.model.CustomerModel
import com.estoquemga.service.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController(private val customerService: CustomerService) {


    @GetMapping
    fun getAll(): List<CustomerModel>{
        return customerService.getAll()
    }

    @GetMapping("/{id}")
    fun getObject(@PathVariable id: Int?): CustomerModel{
        return customerService.getObject(id)
    }


    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: PostCustomerRequest){
        customerService.create(customer.toCustomerModel())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody @Valid customer: PutCustomerRequest){
        customerService.update(customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        customerService.delete(id)
    }
}