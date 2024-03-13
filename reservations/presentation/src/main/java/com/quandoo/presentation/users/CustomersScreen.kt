package com.quandoo.presentation.users

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
import com.example.domain.util.UiEvent
import com.quandoo.presentation.components.CustomerItem
import com.quandoo.presentation.tables.TablesViewModel


@Composable
fun CustomersScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    customersViewModel: CustomersViewModel = hiltViewModel()
){
    val state = customersViewModel.state

    LaunchedEffect(key1 = true)
    {
        customersViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }
                else -> Unit
            }
        }
    }

    Column(
    )
    {
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
                    text = "Costumers List",
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
            items(state.customers.size) {

                CustomerItem(
                    customer = state.customers[it],
                    onItemClick = {selectedCustomerId ->
                        customersViewModel.saveCustomerPreference(selectedCustomerId)
                        customersViewModel.insertReservation()
                        customersViewModel.onSelectedCustomer()
                    })
            }
        }
    }
}

