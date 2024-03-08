package com.quandoo.data.api

import com.quandoo.domain.Table
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {
        @GET("books")
        suspend fun getTables(): Response<List<Table>>
}