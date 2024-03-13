package com.quandoo.presentation.tables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.SelectedReservation
import com.example.domain.util.UiEvent
import com.quandoo.presentation.components.ReserveDialog
import com.quandoo.presentation.components.TableItem

@Composable
fun TablesScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    tablesViewModel: TablesViewModel = hiltViewModel()
) {
    val state = tablesViewModel.state

    LaunchedEffect(key1 = true) {
        tablesViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }

                is UiEvent.ShowCustomDialog -> {
                    tablesViewModel.setShowDialog(true)
                }

                else -> Unit
            }
        }
    }

    ReserveDialog(show = state.showDialog,
        reserveNumber = state.selectedReservation?.reservationId.toString(),
        reservedBy = state.selectedReservation?.customerName,
        tableNumber = state.selectedReservation?.tableId.toString(),
        image = state.selectedReservation?.customerImage,
        onDismiss = { tablesViewModel.setShowDialog(false) },
        onDelete = {
            tablesViewModel.deleteReserve(state.selectedReservation?.reservationId ?: 0)
            tablesViewModel.setShowDialog(false)
        })

    Column(

    ) {
        Card(
            modifier = Modifier.fillMaxWidth(), elevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {

                Text(
                    text = "Reserved tables",
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.h1,
                    maxLines = 1,
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            items(state.tables.size) {
                val customer = tablesViewModel.findReservationUserName(
                    state.reservations, state.customers, state.tables[it].id
                )
                val reservation = tablesViewModel.getReservationIdIfTableReserved(
                    state.tables[it], state.reservations
                )
                val table = state.tables[it]
                val customerName = customer?.firstName + " " + customer?.lastName
                val selectedReservation = SelectedReservation(
                    customerName,
                    reservation?.id ?: 0,
                    reservation?.tableId ?: 0,
                    customer?.imageUrl ?: ""
                )

                TableItem(tableId = table.id,
                    customer = customer,
                    shape = table.shape,
                    hasReserve = reservation != null,
                    onItemClick = {tableId ->
                        if (reservation != null) {
                            tablesViewModel.showCustomDialog()
                            tablesViewModel.setSelectedReservation(selectedReservation)
                        } else {
                            tablesViewModel.onNextClick(tableId)
                        }
                    })
            }
        }
    }
}

