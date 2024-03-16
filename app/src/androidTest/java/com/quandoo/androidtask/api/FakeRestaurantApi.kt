package com.quandoo.androidtask.api

//class FakeRestaurantApi : RestaurantApi {
//
//    override suspend fun getTables(): Response<List<Table>> {
//        // Simular una respuesta exitosa con datos de mesa predefinidos
//        val tableDtos = listOf(
//            Table("Rectangular", 1),
//            Table("Circular", 2),
//            Table("Square", 3)
//        )
//        return Response.success(tableDtos.map { it })
//    }
//
//    override suspend fun getCustomer(): Response<List<CustomerDto>> {
//        // Simular una respuesta exitosa con datos de cliente predefinidos
//        val customerDtos = listOf(
//            CustomerDto(1, "John", "Doe",  "https://example.com/john.jpg"),
//            CustomerDto(2, "Jane", "Smith", "https://example.com/jane.jpg")
//            // Agregar más clientes según sea necesario
//        )
//        return Response.success(customerDtos)
//    }
//
//    override suspend fun getReservations(): Response<List<ReservationDto>> {
//        // Simular una respuesta exitosa con datos de reservas predefinidos
//        val reservationDtos = listOf(
//            ReservationDto(1, 1, 1),
//            ReservationDto(2, 2, 2)
//            // Agregar más reservas según sea necesario
//        )
//        return Response.success(reservationDtos)
//    }
//}