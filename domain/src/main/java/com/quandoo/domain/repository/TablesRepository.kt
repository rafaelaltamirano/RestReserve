package com.quandoo.domain.repository

import com.quandoo.domain.Table
import com.quandoo.domain.data_source.remote.TablesRemoteSource

interface TablesRepository : LocalSource<List<Table>>, TablesRemoteSource