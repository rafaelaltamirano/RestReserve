package com.example.domain.repository

import com.example.domain.LocalSource
import com.example.domain.Table


interface TablesRepository: LocalSource<List<Table>> {

    suspend fun getTables(): Result<List<Table>>

}