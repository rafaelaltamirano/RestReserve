package com.quandoo.data.remote.dto

import com.squareup.moshi.Json

data class CustomerDto(
    val id: Int,
    @field:Json(name = "first_name") val firstName: String,
    @field:Json(name = "last_name") val lastName: String,
    @field:Json(name = "image_url") val imageUrl: String
)