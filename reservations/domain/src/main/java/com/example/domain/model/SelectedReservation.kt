package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
data class SelectedReservation(
    val customerName: String,
    val reservationId: Int,
    val tableId: Int,
    val customerImage: String
)