package com.quandoo.presentation.tables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.util.UiEvent
import com.quandoo.presentation.components.TableItem

@Composable
fun TablesScreen (
    onNavigate: (UiEvent.Navigate) -> Unit,
    tablesViewModel: TablesViewModel = hiltViewModel()
){


    LazyColumn(
    modifier = Modifier.fillMaxSize()
    ) {
        items(tablesViewModel.state.tables.size) {
            TableItem(
                tableId = tablesViewModel.state.tables[it].id,
                reservedBy = "dsad",
                shape = "circle"
            )
        }
    }
}