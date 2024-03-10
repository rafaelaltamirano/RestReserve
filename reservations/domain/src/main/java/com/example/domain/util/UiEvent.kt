package com.example.domain.util

//Sealed class to define which type of events we would like to send from VM to
// composable. There have to be events that we wanna use once, not states.
sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
    data class ShowSnackBar(val message: String) : UiEvent()
}