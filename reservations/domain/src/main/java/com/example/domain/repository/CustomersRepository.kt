package com.example.domain.repository

import com.example.domain.LocalSource
import com.example.domain.Customer

interface CustomersRepository: LocalSource<List<Customer>> {

    suspend fun getCustomers(): Result<List<Customer>>

}