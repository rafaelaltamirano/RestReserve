package com.example.domain.preferences

import android.content.SharedPreferences
import com.example.domain.model.Reservation
import com.example.domain.preferences.Preferences.Companion.FIRST_RUN
import com.example.domain.preferences.Preferences.Companion.KEY_CUSTOMER
import com.example.domain.preferences.Preferences.Companion.KEY_TABLE

class DefaultPreferences
    (
    private val sharedPreferences: SharedPreferences
) : Preferences {

    override fun saveCustomer(customerId: Int) {
        sharedPreferences.edit().putInt(KEY_CUSTOMER, customerId).apply()
    }

    override fun saveTable(tableId: Int) {
        sharedPreferences.edit().putInt(KEY_TABLE, tableId).apply()
    }

    override fun saveFirstRun(firstRun: Boolean) {
        sharedPreferences.edit().putBoolean(FIRST_RUN, firstRun).apply()
    }

    override fun loadFirstRun(): Boolean {
        return sharedPreferences.getBoolean(FIRST_RUN, false)
    }

    override fun loadReserve(): Reservation {
        val customerId = sharedPreferences.getInt(KEY_CUSTOMER, 0)
        val tableId = sharedPreferences.getInt(KEY_TABLE, 0)
        return Reservation(customerId, tableId, 0)
    }
}