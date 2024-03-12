package com.quandoo.data.mapper

import com.example.domain.model.Reservation
import com.quandoo.data.remote.dto.ReservationDto

fun ReservationDto.toReservation(): Reservation {

    return Reservation(
        id = id,
        tableId = tableId,
        userId = userId,
    )
}