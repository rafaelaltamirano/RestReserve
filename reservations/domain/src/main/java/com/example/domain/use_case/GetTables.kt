package com.example.domain.use_case

import com.example.domain.model.Table
import com.example.domain.repository.TablesRepository

class GetTables (
    private val repository: TablesRepository
){
    suspend operator fun invoke(
    ): Result<List<Table>> {
        return repository.getTables()
    }
}