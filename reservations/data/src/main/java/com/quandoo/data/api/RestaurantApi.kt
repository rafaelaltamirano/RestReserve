package com.quandoo.data.api

import com.example.domain.model.Table
import com.quandoo.data.remote.dto.CustomerDto
import com.quandoo.data.remote.dto.ReservationDto
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {
    @GET("quandoo-assessment/tables.json")
    suspend fun getTables(): Response<List<Table>>

    @GET("quandoo-assessment/customers.json")
    suspend fun getCustomer(): Response<List<CustomerDto>>

    @GET("quandoo-assessment/reservations.json")
    suspend fun getReservations(): Response<List<ReservationDto>>

    companion object {
        const val BASE_URL = "https://s3-eu-west-1.amazonaws.com/"
    }

}

