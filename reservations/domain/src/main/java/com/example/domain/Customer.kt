package com.example.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customer(
    @PrimaryKey val id: Int,
    val firstName: String,
    val lastName: String,
    val imageUrl: String
)