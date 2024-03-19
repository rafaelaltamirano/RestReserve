package com.quandoo.androidtask.navigation

import androidx.navigation.NavController
import com.quandoo.core.util.UiEvent

fun NavController.navigate(event: com.quandoo.core.util.UiEvent.Navigate) {
    this.navigate(event.route)
}