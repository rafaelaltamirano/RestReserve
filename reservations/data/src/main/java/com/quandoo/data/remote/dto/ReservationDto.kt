package com.quandoo.data.remote.dto

import com.squareup.moshi.Json

data class ReservationDto(
    @field:Json(name = "user_id")
    val userId: Int,
    @field:Json(name = "table_id")
    val tableId: Int,
    val id: Int
)