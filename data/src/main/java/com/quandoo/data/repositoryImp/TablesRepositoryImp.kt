package com.quandoo.data.repositoryImp

import com.quandoo.domain.Table
import com.quandoo.domain.data_source.local.TablesLocalSource
import com.quandoo.domain.data_source.remote.TablesRemoteSource
import com.quandoo.domain.repository.TablesRepository

class TablesRepositoryImp(
    private val tablesRemote: TablesRemoteSource,
    private val local: TablesLocalSource
) : TablesRepository {

    var tables: List<Table> = emptyList()

    override suspend fun getTables() = tablesRemote.getTables().also { save(it) }
    override suspend fun save(t: List<Table>) {
        tables = t
        local.save(t)
    }

    override suspend fun load(): List<Table> = (local.load() ?: emptyList()).also {
        this.tables = it
    }

    override suspend fun clear() = local.clear().also { this.tables = emptyList() }

}