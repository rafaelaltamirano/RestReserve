package com.example.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tables")
data class Table(
    val shape: String,
    @PrimaryKey(autoGenerate = false) val id: Long,
)
