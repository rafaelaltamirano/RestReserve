package com.quandoo.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

open class ViewModelWithStatus : ViewModel() {

    var status by mutableStateOf<ModelStatus?>(null)
        protected set

    var errorStatus by mutableStateOf<ErrorStatus?>(ErrorStatus())
        protected set

    fun clearStatus() {
        status = null
    }

    fun handleNetworkError(e: Exception) {
        status = ModelStatus(Status.ERROR,e.message.toString())
    }
}