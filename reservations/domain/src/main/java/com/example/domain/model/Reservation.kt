package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservation")
data class Reservation(
    val userId: Long,
    val tableId: Long,
    @PrimaryKey(autoGenerate = true) val id: Long
)