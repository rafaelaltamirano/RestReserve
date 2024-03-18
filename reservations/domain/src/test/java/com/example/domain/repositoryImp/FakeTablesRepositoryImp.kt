package com.example.domain.repositoryImp

import com.example.domain.model.Table
import com.example.domain.repository.TablesRepository

class FakeTablesRepositoryImp : TablesRepository {

     var tables: List<Table> = emptyList()

    override suspend fun getTables(): Result<List<Table>> {
        return try {
            if (tables.isNotEmpty()) {
                Result.success(tables)
            } else {
                val fakeTables = generateFakeTables() // Generar datos falsos
                tables = fakeTables
                Result.success(fakeTables)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun save(t: List<Table>) {
        tables = t
        // No es necesario hacer nada en un repositorio falso
    }

    override suspend fun load(): List<Table> {
        return tables
    }

    private fun generateFakeTables(): List<Table> {
        // Genera una lista de mesas falsas
        return listOf(
            Table(shape = "Circle", id = 1),
            Table(shape = "Square", id = 2),
            Table(shape = "Rectangle", id = 3)
        )
    }
}