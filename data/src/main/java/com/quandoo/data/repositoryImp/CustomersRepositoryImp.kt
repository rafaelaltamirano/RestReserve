package com.quandoo.data.repositoryImp

import com.quandoo.domain.Customer
import com.quandoo.domain.data_source.local.CustomersLocalSource
import com.quandoo.domain.data_source.remote.CustomersRemoteSource
import com.quandoo.domain.repository.CustomersRepository

class CustomersRepositoryImp(
    private val remote: CustomersRemoteSource,
    private val local: CustomersLocalSource
) : CustomersRepository {

    var customer: List<Customer> = emptyList()

    override suspend fun getCustomers() = remote.getCustomers().also { this.customer = it }
    override suspend fun save(t: List<Customer>) {
        customer = t
        local.save(t)
    }

    override suspend fun load(): List<Customer> = (local.load() ?: emptyList()).also {
        this.customer = it
    }

    override suspend fun clear() = local.clear().also { this.customer = emptyList() }

}