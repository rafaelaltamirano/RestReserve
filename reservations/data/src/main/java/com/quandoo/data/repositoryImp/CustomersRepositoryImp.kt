package com.quandoo.data.repositoryImp

import com.quandoo.data.api.RestaurantApi
import com.quandoo.data.dao.CustomersDao
import com.example.domain.Customer
import com.example.domain.repository.CustomersRepository

class CustomersRepositoryImp(
    private val dao: CustomersDao,
    private val api: RestaurantApi
) : CustomersRepository {

    var customers: List<Customer> = emptyList()
    override suspend fun getCustomers(): Result<List<Customer>> {
        return try {
            // Intenta cargar los datos de la caché
            val cachedCustomers = load()
            if (cachedCustomers.isNotEmpty()) {
                Result.success(cachedCustomers)
            } else {
                // Si no hay datos en caché, llama a la API
                val dto = api.getCustomer()
                val customers = dto.body() ?: emptyList()
                // Guarda los datos en caché
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