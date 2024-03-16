package com.quandoo.androidtask.repositoryImp

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
        // Simplemente actualizar la lista de reservas, eliminando la reserva con el ID dado
        reservations = reservations.filter { it.id != reservationId }
    }

    override suspend fun insertReservation(reservation: Reservation) {
        // Simplemente agregar la reserva a la lista de reservas
        reservations += reservation
    }

    override suspend fun save(t: List<Reservation>) {
        reservations = t
        // No es necesario hacer nada en un repositorio falso
    }

    override suspend fun load(): List<Reservation> {
        return reservations
    }

    private fun generateFakeReservations(): List<Reservation> {
        // Generar una lista de reservas falsas
        return listOf(
            Reservation(id = 1, tableId = 1, userId = 1),
            Reservation(id = 2, tableId = 2, userId = 2),
            Reservation(id = 3, tableId = 3, userId = 3)
        )
    }
}