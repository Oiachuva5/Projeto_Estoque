package com.estoquemga.service

import com.estoquemga.enums.CustomerStatus
import com.estoquemga.exception.NotFoundException
import com.estoquemga.helper.buildCustomer
import com.estoquemga.model.CustomerModel
import com.estoquemga.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import java.util.*


@ExtendWith(MockKExtension::class)
@SpringBootTest
class CustomerServiceTest {

    @MockK
    private lateinit var repository: CustomerRepository

    @InjectMockKs
    lateinit var customerService: CustomerService


    @Test
    fun `should return All Customer`() {
        val fakeCustomerList: List<CustomerModel> = listOf(buildCustomer())

        every { repository.findAll() } returns fakeCustomerList

        val listCustomer: List<CustomerModel> = customerService.getAll()
        assertEquals(fakeCustomerList, listCustomer)
        verify(exactly = 1) { repository.findAll() }
    }

    @Test
    fun `should create Customer`() {
        val fakeCustomer: CustomerModel = buildCustomer()

        every { repository.save(fakeCustomer) } returns fakeCustomer

        customerService.create(fakeCustomer)

        verify(exactly = 1) { repository.save(fakeCustomer) }
    }


    @Test
    fun `should return the specific object`() {
        val fakeCustomer: CustomerModel = buildCustomer(id = 10)

        every { repository.findById(10) } returns Optional.of(fakeCustomer)

        val customerSave: CustomerModel = customerService.getObject(10)

        assertEquals(fakeCustomer, customerSave)
        verify(exactly = 1) { repository.findById(10) }
    }

    @Test
    fun `should return the exception before not found the object `() {

        every { repository.findById(10) } returns Optional.empty()

        val error = assertThrows<NotFoundException> { customerService.getObject(10) }

        assertEquals("Customer não existe", error.message)
        assertEquals("CE-001", error.errorCode)

        verify(exactly = 1) { repository.findById(10) }
    }

    @Test
    fun `should inactive customer status`() {
        val fakeCustomer = buildCustomer(id = 10)

        every { repository.findById(10) } returns Optional.of(fakeCustomer)
        every { repository.save(fakeCustomer) } returns fakeCustomer

        customerService.delete(10)

        assertEquals(CustomerStatus.INATIVO, fakeCustomer.status)
        verify(exactly = 1) { repository.findById(10) }
        verify(exactly = 1) { repository.save(fakeCustomer) }
    }


//    @Test
//    fun `should update customer`() {
//        val fakeCustomer: CustomerModel = buildCustomer(id = 10)
//        val alterCustomer = PutCustomerRequest(
//            nomeCompleto = "teste",
//            email = "teste@gmail.com",
//            senha = "teste"
//        )
//
//        val customerSave = CustomerModel(
//            id = 10,
//            nomeCompleto = "teste",
//            login = fakeCustomer.login,
//            email = "teste@gmail.com",
//            senha = "teste",
//            status = fakeCustomer.status
//        )
//
//        every { repository.existsById(10) } returns true
//        every { repository.findById(10).get() } returns fakeCustomer
//        every { repository.save(customerSave) } returns customerSave
//
//        val updateTeste = customerService.update(customer = alterCustomer, id = 10)
//
//        assertEquals(customerSave, updateTeste)
//        verify(exactly = 1) { repository.save(customerSave) }
//        verify(exactly = 1) { repository.existsById(10) }
//        verify(exactly = 1) { repository.findById(10) }
//    }

}