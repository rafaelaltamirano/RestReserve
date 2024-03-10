package com.quandoo.androidtask.navigation

import androidx.navigation.NavController
import com.example.domain.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}