package com.quandoo.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.quandoo.core.R

@Composable
fun AlertDialog(
    title: String, message: String, onPressButton: () -> Unit
) {
    AlertDialog(onDismissRequest = onPressButton, title = {
        Text(
            text = title,
            style = MaterialTheme.typography.h2,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W700,
            color = Color.DarkGray
        )
    }, text = {
        Text(
            text = message,
            style = MaterialTheme.typography.body1,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )

    }, confirmButton = {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                color = Color.DarkGray,
                thickness = 1.dp,
                modifier = Modifier.align(Alignment.TopCenter),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { onPressButton() },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.try_again),
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }, properties = DialogProperties(
        usePlatformDefaultWidth = true,
        dismissOnBackPress = true,
        dismissOnClickOutside = false
    )
    )
}