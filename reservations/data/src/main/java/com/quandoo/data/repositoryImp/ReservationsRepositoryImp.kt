package com.quandoo.data.repositoryImp

import com.quandoo.data.api.RestaurantApi
import com.example.domain.repository.ReservationsRepository
import com.quandoo.data.dao.ReservationsDao
import com.example.domain.model.Reservation

class ReservationsRepositoryImp(
    private val dao: ReservationsDao,
    private val api: RestaurantApi
) : ReservationsRepository {

    var reservations: List<Reservation> = emptyList()
    override suspend fun getReservations(): Result<List<Reservation>> {
        return try {
            val cachedReservations = load()
            if (cachedReservations.isNotEmpty()) {
                Result.success(cachedReservations)
            } else {
                val dto = api.getReservations()
                val reservations = dto.body() ?: emptyList()
                save(reservations)
                Result.success(reservations)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun deleteReservationById(reservationId: Int) {
        dao.deleteReservationById(reservationId)
    }
    override suspend fun insertReservation(reservation: Reservation) {
        dao.insertReservation(reservation)
    }

    override suspend fun save(t: List<Reservation>) {
        reservations = t
        dao.insertAll(t)
    }

    override suspend fun load(): List<Reservation> = (dao.getAll()).also {
        this.reservations = it
    }

}