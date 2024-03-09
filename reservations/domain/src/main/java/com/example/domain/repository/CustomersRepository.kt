package com.example.domain.repository

import com.example.domain.model.Customer

interface CustomersRepository: LocalSource<List<Customer>> {

    suspend fun getCustomers(): Result<List<Customer>>

}