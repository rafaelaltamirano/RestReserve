package com.quandoo.core.util

import org.w3c.dom.Text

//Sealed class to define which type of events we would like to send from VM to
// composable. There have to be events that we wanna use once, not states.
sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
    object ShowCustomDialog : UiEvent()
}