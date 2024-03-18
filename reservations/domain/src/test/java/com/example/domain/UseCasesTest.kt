package com.example.domain

import com.example.domain.model.Customer
import com.example.domain.model.Reservation
import com.example.domain.repository.CustomersRepository
import com.example.domain.repository.ReservationsRepository
import com.example.domain.use_case.GetCustomers
import com.example.domain.use_case.GetReservations
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UseCasesTest {

    private lateinit var customersRepository: CustomersRepository
    private lateinit var reservationsRepository: ReservationsRepository
    private lateinit var getCustomers: GetCustomers
    private lateinit var getReservations: GetReservations
    private lateinit var expectedCustomers: List<Customer>
    private lateinit var expectedReservations: List<Reservation>

    @Before
    fun setUp() {
        customersRepository =  mockk()
        reservationsRepository = mockk()
        getCustomers = GetCustomers(customersRepository)
        getReservations = GetReservations(reservationsRepository)

         expectedCustomers = listOf(
            Customer(id = 1, firstName = "John", lastName = "Doe", imageUrl = "https://example.com/johndoe.jpg"),
            Customer(id = 2, firstName = "Jane", lastName = "Smith",imageUrl = "https://example.com/janesmith.jpg"),
        )

         expectedReservations = listOf(
            Reservation(userId = 1, tableId = 1, id = 101),
            Reservation(userId = 2, tableId = 2, id = 102),
            Reservation(userId = 3, tableId = 3, id = 103)
        )
    }

    @Test
    fun `invoke should return list of customers when call getCustomers`() {
       coEvery { customersRepository.getCustomers() } returns Result.success(expectedCustomers)

        val result = runBlocking { getCustomers() }

        assertEquals(Result.success(expectedCustomers), result)
    }

    @Test
    fun `invoke should return error when repository getCustomers throws exception`() {
       coEvery { customersRepository.getCustomers() } returns Result.failure(Exception("Repository error"))

       val result = runBlocking { getCustomers() }

       assert(result.isFailure)
        assertEquals("Repository error", result.exceptionOrNull()?.message)
    }

    @Test
    fun `invoke should return list of reservations when call getReservations`() {

        coEvery { reservationsRepository.getReservations() } returns Result.success(expectedReservations)

        val result = runBlocking { getReservations() }

        assertTrue(result.isSuccess)
        assertEquals(expectedReservations, result.getOrNull())
    }

    @Test
    fun `invoke should return error when repository getReservations throws exception`() {
        coEvery { reservationsRepository.getReservations() } returns Result.failure(Exception("Repository error"))

        val result = runBlocking { getReservations() }

        assert(result.isFailure)
    }
}