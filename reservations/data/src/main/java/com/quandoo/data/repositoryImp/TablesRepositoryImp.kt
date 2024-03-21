package com.quandoo.data.repositoryImp

import com.example.domain.model.Table
import com.example.domain.repository.TablesRepository
import com.quandoo.data.api.RestaurantApi
import com.quandoo.data.dao.TablesDao

class TablesRepositoryImp(
    private val dao: TablesDao, private val api: RestaurantApi
) : TablesRepository {

    var tables: List<Table> = emptyList()
    override suspend fun getTables(): Result<List<Table>> {
        return try {
            val cachedTables = load()
            if (cachedTables.isNotEmpty()) {
                Result.success(cachedTables)
            } else {
                val dto = api.getTables()
                if (dto.isSuccessful) {
                    val table = dto.body() ?: emptyList()
                    save(table)
                    Result.success(table)
                } else throw Exception()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun save(t: List<Table>) {
        tables = t
        dao.insertAll(t)
    }

    override suspend fun load(): List<Table> = (dao.getAll()).also {
        this.tables = it
    }

}