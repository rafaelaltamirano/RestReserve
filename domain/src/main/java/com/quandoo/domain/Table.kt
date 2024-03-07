package com.quandoo.domain

data class Table(
    val shape: String,
    val id: Long,
    val reservedBy: String? = null
)
