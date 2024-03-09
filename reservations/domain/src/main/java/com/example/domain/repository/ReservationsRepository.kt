package com.example.domain.repository

import com.example.domain.LocalSource
import com.quandoo.domain.Reservation

interface ReservationsRepository : LocalSource<List<Reservation>> {

    suspend fun getReservations(): Result<List<Reservation>>
    suspend fun insertReservation(reservation: Reservation)

    suspend fun deleteReservationById(reservationId: Int)


}