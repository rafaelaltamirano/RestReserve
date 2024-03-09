package com.quandoo.data.api

import com.example.domain.model.Customer
import com.example.domain.model.Reservation
import com.example.domain.model.Table
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {
        @GET("/quandoo-assessment/tables.json")
        suspend fun getTables(): Response<List<Table>>

        @GET("/quandoo-assessment/customers.json")
        suspend fun getCustomer(): Response<List<Customer>>

        @GET("/quandoo-assessment/reservations.json")
        suspend fun getReservations(): Response<List<Reservation>>
}