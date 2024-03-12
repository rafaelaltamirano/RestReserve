package com.quandoo.presentation.tables

import com.example.domain.model.Customer
import com.example.domain.model.Reservation
import com.example.domain.model.SelectedReservation
import com.example.domain.model.Table

data class TablesState(
    val tables: List<Table> = emptyList(),
    val reservations: List<Reservation> = emptyList(),
    val customers: List<Customer> = emptyList(),
    val showDialog: Boolean = false,
    val selectedReservation: SelectedReservation? = null
)