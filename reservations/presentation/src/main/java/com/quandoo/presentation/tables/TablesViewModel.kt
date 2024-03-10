package com.quandoo.presentation.tables

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Reservation
import com.example.domain.model.Table
import com.example.domain.use_case.GetReservations
import com.example.domain.use_case.GetTables
import com.quandoo.presentation.ViewModelWithStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TablesViewModel @Inject constructor(
    private val getTables: GetTables,
    private val getReservations: GetReservations,
) : ViewModelWithStatus() {

    var state by mutableStateOf(TablesState())
        private set

    init {
        requestTables()
    }

    private fun setTables(tables: List<Table>) {
        state = state.copy(tables = tables)
    }

    private fun setReservations(reservation: List<Reservation>) {
        state = state.copy(reservation = reservation)
    }

    fun requestTables() = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getTables()
            }
            setTables(result.getOrNull() ?: emptyList())
        } catch (e: Exception) {
            handleNetworkError(e)
        }
    }

    fun requestReservation() = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getReservations()
            }
            setReservations(result.getOrNull() ?: emptyList())
        } catch (e: Exception) {
            handleNetworkError(e)
        }
    }
}
