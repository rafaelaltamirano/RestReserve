package com.example.domain.repository

import com.example.domain.model.Table


interface TablesRepository: LocalSource<List<Table>> {

    suspend fun getTables(): Result<List<Table>>

}