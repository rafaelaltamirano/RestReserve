package com.quandoo.presentation.users

import com.example.domain.model.Customer

data class CustomerState(
    val customers: List<Customer> = emptyList(),
    val selectedCustomer: Customer? = null
)