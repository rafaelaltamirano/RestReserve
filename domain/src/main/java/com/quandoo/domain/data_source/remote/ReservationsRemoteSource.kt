package com.quandoo.domain.data_source.remote

import com.quandoo.domain.Reservation

interface ReservationsRemoteSource {

    suspend fun getReservations(): List<Reservation>

}
