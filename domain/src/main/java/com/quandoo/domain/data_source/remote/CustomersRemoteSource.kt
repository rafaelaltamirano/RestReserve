package com.quandoo.domain.data_source.remote

import com.quandoo.domain.Customer

interface CustomersRemoteSource {

    suspend fun getCustomers(): List<Customer>

}
