package com.example.domain.use_case

import com.example.domain.repository.ReservationsRepository

class DeleteReservation (
    private val repository: ReservationsRepository
){
    suspend operator fun invoke(reserveId: Int) {
        repository.deleteReservationById(reserveId)
    }
}