package com.example.domain.use_case

import com.example.domain.model.Reservation
import com.example.domain.repository.ReservationsRepository

class LoadReservations(
    private val repository: ReservationsRepository
) {
    suspend operator fun invoke(
    ): List<Reservation>? {
        return repository.load()
    }
}