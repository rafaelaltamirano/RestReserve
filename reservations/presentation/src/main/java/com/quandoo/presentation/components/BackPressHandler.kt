package com.quandoo.presentation.components

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.quandoo.core.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BackPressHandler(enabled: Boolean = true) {
    val text = stringResource(R.string.back_press_exit)
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val isBackPressed = remember { mutableStateOf(false) }
    BackHandler(enabled && !isBackPressed.value) {
        isBackPressed.value = true
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        scope.launch {
            delay(2000L)
            isBackPressed.value = false
        }
    }
}