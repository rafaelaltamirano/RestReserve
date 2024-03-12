package com.quandoo.data.repositoryImp

import com.quandoo.data.api.RestaurantApi
import com.quandoo.data.dao.CustomersDao
import com.example.domain.model.Customer
import com.example.domain.repository.CustomersRepository
import com.quandoo.data.mapper.toCustomer
import com.quandoo.data.mapper.toReservation

class CustomersRepositoryImp(
    private val dao: CustomersDao,
    private val api: RestaurantApi
) : CustomersRepository {

    private var customers: List<Customer> = emptyList()
    override suspend fun getCustomers(): Result<List<Customer>> {
        return try {
            // try to get data from cache
            val cachedCustomers = load()
            if (cachedCustomers.isNotEmpty()) {
                Result.success(cachedCustomers)
            } else {
                // if there is no data in cache, get data from api
                val dto = api.getCustomer()
                val customers = dto.body()?.map { it.toCustomer() } ?: emptyList()
                // Save data in cache
                save(customers)
                Result.success(customers)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun save(t: List<Customer>) {
        customers = t
        dao.insertAll(t)
    }

    override suspend fun load(): List<Customer> = (dao.getAll()).also {
        this.customers = it
    }

}