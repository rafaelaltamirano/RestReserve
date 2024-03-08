package com.quandoo.domain.data_source.remote

import com.quandoo.domain.Table

interface TablesRemoteSource {

    suspend fun getTables(): List<Table>

}
