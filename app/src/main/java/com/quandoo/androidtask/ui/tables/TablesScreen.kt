package com.quandoo.androidtask.ui.tables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quandoo.androidtask.ui.components.TableItem

@Composable
fun TablesScreen (
){
    LazyColumn(
    modifier = Modifier.fillMaxSize()
    ) {
        items(5) {
            TableItem(tableId = 1231L, reservedBy = "dsad", shape = "circle")
        }
    }
}