package com.quandoo.androidtask

import androidx.compose.runtime.Composable
import com.quandoo.presentation.components.AlertDialog

@Composable
fun ShowNoInternetDialog(onConnect: () -> Unit) {
    AlertDialog(
        title = "Not internet connection",
        message = "Please, connect your device to the internet to continue.",
        onPressButton = onConnect
    )
}