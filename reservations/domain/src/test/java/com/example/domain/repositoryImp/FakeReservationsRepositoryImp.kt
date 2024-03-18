package com.example.domain.repositoryImp

import com.example.domain.model.Reservation
import com.example.domain.repository.ReservationsRepository

class FakeReservationsRepositoryImp : ReservationsRepository {

     var reservations: List<Reservation> = emptyList()

    override suspend fun getReservations(): Result<List<Reservation>> {
        return try {
            if (reservations.isNotEmpty()) {
                Result.success(reservations)
            } else {
                val fakeReservations = generateFakeReservations() // Generar datos falsos
                reservations = fakeReservations
                Result.success(fakeReservations)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteReservationById(reservationId: Int) {
        reservations = reservations.filter { it.id != reservationId }
    }

    override suspend fun insertReservation(reservation: Reservation) {
        reservations += reservation
    }

    override suspend fun save(t: List<Reservation>) {
        reservations = t
    }

    override suspend fun load(): List<Reservation> {
        return reservations
    }

    private fun generateFakeReservations(): List<Reservation> {
        return listOf(
            Reservation(userId = 2, tableId = 2, id = 102),
            Reservation(userId = 3, tableId = 3, id = 103)
        )
    }
}