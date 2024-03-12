package com.quandoo.data.mapper

import com.example.domain.model.Customer
import com.quandoo.data.remote.dto.CustomerDto

fun CustomerDto.toCustomer(): Customer {
    return Customer(
        id = id,
        firstName = firstName,
        lastName = lastName,
        imageUrl = imageUrl
    )
}