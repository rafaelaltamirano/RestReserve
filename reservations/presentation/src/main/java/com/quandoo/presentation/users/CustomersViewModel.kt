package com.quandoo.presentation.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Customer
import com.example.domain.preferences.Preferences
import com.example.domain.use_case.GetCustomers
import com.example.domain.use_case.InsertReservation
import com.quandoo.core.util.UiEvent
import com.quandoo.presentation.ViewModelWithStatus
import com.quandoo.presentation.navigation.Route.TABLES
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel  @Inject constructor(
    private val getCustomers: GetCustomers,
    private val insertReservation: InsertReservation,
    private val preferences: Preferences,
) : ViewModelWithStatus() {
    var state by mutableStateOf(CustomerState())
        private set

    init {
        loadCustomers()
    }

    private val _uiEvent = Channel<com.quandoo.core.util.UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private fun setCustomers(customers: List<Customer>) {
        state = state.copy(customers = customers)
    }

    fun saveCustomerPreference(id:Int) {
        preferences.saveCustomer(id)
    }

    fun onSelectedCustomer() {
        viewModelScope.launch {
            _uiEvent.send(com.quandoo.core.util.UiEvent.Navigate(TABLES))
        }
    }

    fun loadCustomers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getCustomers.invoke()
            }.also {
                setCustomers(it.getOrNull() ?: emptyList())
            }
        }
    }

    fun insertReservation() {
        viewModelScope.launch {
            val newReserve = preferences.loadReserve()
            insertReservation.invoke(newReserve)
        }
    }
}