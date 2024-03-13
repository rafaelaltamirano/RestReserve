package com.example.domain.preferences

import com.example.domain.model.Customer
import com.example.domain.model.Reservation

interface Preferences {
    fun saveCustomer(customerId: Int)

    fun saveTable(tableId: Int)

    fun loadReserve(): Reservation

    companion object {
        const val KEY_CUSTOMER = "customer"
        const val KEY_TABLE = "table"
    }

}