package com.quandoo.data.repositoryImp

import com.quandoo.data.api.RestaurantApi
import com.example.domain.repository.ReservationsRepository
import com.quandoo.data.dao.ReservationsDao
import com.example.domain.model.Reservation
import com.quandoo.data.dao.TablesDao
import com.quandoo.data.mapper.toReservation

class ReservationsRepositoryImp(
    private val reservationDao: ReservationsDao,
    private val tablesDao: TablesDao,
    private val api: RestaurantApi
) : ReservationsRepository {

    private var reservations: List<Reservation> = emptyList()
    override suspend fun getReservations(): Result<List<Reservation>> {
        return try {
             val cachedReservations = load()
            val tables = tablesDao.getAll()
            if (cachedReservations.isNotEmpty() || tables.isNotEmpty()) {
                Result.success(cachedReservations)
            } else {
                val dto = api.getReservations()
                val reservations = dto.body()?.map { it.toReservation() } ?: emptyList()
                save(reservations)
                Result.success(reservations)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun deleteReservationById(reservationId: Int) {
        reservationDao.deleteReservationById(reservationId)
    }
    override suspend fun insertReservation(reservation: Reservation) {
        reservationDao.insertReservation(reservation)
    }

    override suspend fun save(t: List<Reservation>) {
        reservations = t
        reservationDao.insertAll(t)
    }

    override suspend fun load(): List<Reservation> = (reservationDao.getAll()).also {
        this.reservations = it
    }

}