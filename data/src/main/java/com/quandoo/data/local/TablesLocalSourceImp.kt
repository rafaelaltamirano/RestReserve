package com.example.data.local

import com.quandoo.data.dao.TablesDao
import com.quandoo.domain.Table
import com.quandoo.domain.data_source.local.TablesLocalSource
import javax.inject.Inject

class TablesLocalSourceImp @Inject constructor(private val tablesDao: TablesDao) :
    TablesLocalSource {

    override suspend fun save(t: List<Table>) {
        tablesDao.insertAll(t)
    }

    override suspend fun load(): List<Table> {
        return tablesDao.getAll()
    }

    override suspend fun clear() {
        return tablesDao.deleteAll()
    }

}