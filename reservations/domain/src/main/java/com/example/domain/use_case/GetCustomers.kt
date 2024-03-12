package com.example.domain.use_case

import com.example.domain.model.Customer
import com.example.domain.repository.CustomersRepository

class GetCustomers (
    private val repository: CustomersRepository
){
    suspend operator fun invoke(
    ): Result<List<Customer>> {
        return repository.getCustomers()
    }
}