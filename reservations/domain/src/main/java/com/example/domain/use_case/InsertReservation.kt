package com.example.domain.use_case

import com.example.domain.model.Reservation
import com.example.domain.repository.ReservationsRepository

class InsertReservation(
    private val repository: ReservationsRepository
) {
    suspend operator fun invoke(
        reservation: Reservation
    ) {
        return repository.insertReservation(reservation)
    }
}