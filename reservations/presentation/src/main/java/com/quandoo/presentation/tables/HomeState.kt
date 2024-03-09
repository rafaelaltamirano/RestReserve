package com.quandoo.presentation.tables

import com.example.domain.model.Reservation
import com.example.domain.model.Table

data class TablesState(
    val tables: List<Table> = emptyList(),
    val reservation: List<Reservation> = emptyList(),
)