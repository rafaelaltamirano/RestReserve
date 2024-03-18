package com.example.domain.repositoryImp

import com.example.domain.model.Customer
import com.example.domain.repository.CustomersRepository

class FakeCustomersRepositoryImp : CustomersRepository {

     var customers: List<Customer> = emptyList()

    override suspend fun getCustomers(): Result<List<Customer>> {
        return try {
            if (customers.isNotEmpty()) {
                Result.success(customers)
            } else {
                val fakeCustomers = generateFakeCustomers() // Generar datos falsos
                customers = fakeCustomers
                Result.success(fakeCustomers)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun save(t: List<Customer>) {
        customers = t
    }

    override suspend fun load(): List<Customer> {
        return customers
    }

    private fun generateFakeCustomers(): List<Customer> {
        return listOf(
            Customer(id = 1, firstName = "John", lastName = "Doe", imageUrl = ""),
            Customer(id = 2, firstName = "Alice", lastName = "Smith",imageUrl = ""),
            Customer(id = 3, firstName = "Bob", lastName = "Johnson",imageUrl = "")
        )
    }
}