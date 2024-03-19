package com.quandoo.core.util

import android.content.Context

sealed class UiText {
    data class DynamicString(val value: String): UiText()
    data class StringResource(val resId: Int): UiText()

    fun asString(context : Context): String{
        return when(this){
            is DynamicString -> value
            is StringResource -> context.getString(resId)
        }
    }
}

