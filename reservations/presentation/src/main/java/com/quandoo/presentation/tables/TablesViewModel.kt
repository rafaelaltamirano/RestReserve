package com.quandoo.presentation.tables

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Customer
import com.example.domain.model.Reservation
import com.example.domain.model.SelectedReservation
import com.example.domain.model.Table
import com.example.domain.preferences.Preferences
import com.example.domain.use_case.DeleteReservation
import com.example.domain.use_case.GetCustomers
import com.example.domain.use_case.GetReservations
import com.example.domain.use_case.GetTables
import com.example.domain.use_case.LoadReservations
import com.quandoo.core.util.UiEvent
import com.quandoo.presentation.ViewModelWithStatus
import com.quandoo.presentation.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TablesViewModel @Inject constructor(
    private val getTables: GetTables,
    private val getReservations: GetReservations,
    private val getCustomers: GetCustomers,
    private val deleteReservation: DeleteReservation,
    private val loadReservations: LoadReservations,
    private val preferences: Preferences
) : ViewModelWithStatus() {

    var state by mutableStateOf(TablesState())
        private set


    private val _uiEvent = Channel<com.quandoo.core.util.UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        viewModelScope.launch {

            val tablesDeferred = async { requestTables() }
            val customersDeferred = async { requestCustomers() }

            tablesDeferred.await()
            customersDeferred.await()

            requestReservation()
        }
    }
    private fun setTables(tables: List<Table>) {
        state = state.copy(tables = tables)
    }

    private fun setReservations(reservation: List<Reservation>) {
        state = state.copy(reservations = reservation)
    }

    private fun setCustomers(customers: List<Customer>) {
        state = state.copy(customers = customers)
    }

     fun setShowDialog(showDialog: Boolean) {
        state = state.copy(showDialog = showDialog)
    }

    fun setSelectedReservation(selectedReservation: SelectedReservation) {
        state = state.copy(selectedReservation = selectedReservation)
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

    fun requestCustomers() = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getCustomers()
            }
            setCustomers(result.getOrNull() ?: emptyList())
        } catch (e: Exception) {
            handleNetworkError(e)
        }
    }

    fun showCustomDialog() {
        viewModelScope.launch {
            _uiEvent.send(com.quandoo.core.util.UiEvent.ShowCustomDialog)
        }
    }

    fun getReservationIdIfTableReserved(table: Table, reservations: List<Reservation>): Reservation? {
        return reservations.find { it.tableId == table.id }
    }

    fun findReservationUserName(reservationList: List<Reservation>, customerList: List<Customer>, tableId: Int): Customer? {
        val reservation = reservationList.find { it.tableId == tableId }
        return reservation?.let { reservation ->
            customerList.find { it.id == reservation.userId }
        }
    }

    fun deleteReserve(reserveId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                deleteReservation.invoke(reserveId)
            }.also { loadReservations()}
        }
    }

    fun loadReservations() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                loadReservations.invoke()

            }.also {
                setReservations(it ?: emptyList())
            }
        }
    }

    fun onNextClick(tableId: Int) {
        viewModelScope.launch {
            preferences.saveTable(tableId)
            _uiEvent.send(com.quandoo.core.util.UiEvent.Navigate(Route.CUSTOMERS))
        }
    }

}
