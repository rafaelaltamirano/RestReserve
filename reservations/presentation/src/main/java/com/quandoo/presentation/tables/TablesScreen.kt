package com.quandoo.presentation.tables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quandoo.presentation.components.TableItem

@Composable
fun TablesScreen (
){
    LazyColumn(
    modifier = Modifier.fillMaxSize()
    ) {
        items(5) {
            com.quandoo.presentation.components.TableItem(
                tableId = 1231L,
                reservedBy = "dsad",
                shape = "circle"
            )
        }
    }
}