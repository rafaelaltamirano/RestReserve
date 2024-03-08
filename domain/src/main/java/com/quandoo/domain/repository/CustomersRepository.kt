package com.quandoo.domain.repository

import com.quandoo.domain.Customer
import com.quandoo.domain.data_source.remote.CustomersRemoteSource
import com.quandoo.domain.data_source.remote.TablesRemoteSource

interface CustomersRepository : LocalSource<List<Customer>>, CustomersRemoteSource