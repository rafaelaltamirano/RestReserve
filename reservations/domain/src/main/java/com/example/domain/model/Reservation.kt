package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservations")
data class Reservation(
    val userId: Int,
    val tableId: Int,
    @PrimaryKey(autoGenerate = true) val id: Int
)