package com.quandoo.data.api

import com.example.domain.Customer
import com.quandoo.domain.Reservation
import com.example.domain.Table
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {
        @GET("books")
        suspend fun getTables(): Response<List<Table>>

        @GET("books")
        suspend fun getCustomer(): Response<List<Customer>>

        @GET("books")
        suspend fun getReservations(): Response<List<Reservation>>
}