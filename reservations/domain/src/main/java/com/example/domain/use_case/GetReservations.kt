package com.example.domain.use_case

import com.example.domain.model.Reservation
import com.example.domain.repository.ReservationsRepository

class GetReservations (
    private val repository: ReservationsRepository
){
    suspend operator fun invoke(
    ): Result<List<Reservation>> {
        return repository.getReservations()
    }
}