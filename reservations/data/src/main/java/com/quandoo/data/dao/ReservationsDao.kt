package com.quandoo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.Reservation

@Dao
interface ReservationsDao {

    @Query("SELECT * FROM  reservations")
    suspend fun getAll(): List<Reservation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(reservations: List<Reservation>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReservation(reservation: Reservation)

    @Query("DELETE FROM reservations WHERE id = :reservationId")
    suspend fun deleteReservationById(reservationId: Int)
}