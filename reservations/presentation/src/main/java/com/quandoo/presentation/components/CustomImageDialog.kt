package com.quandoo.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberAsyncImagePainter
import com.quandoo.presentation.R

@Composable
fun CustomImageDialog(
    show: Boolean = false,
    reserveNumber: String? = "",
    reservedBy: String? = "",
    tableNumber: String? = "",
    image: String? = "https://static-00.iconduck.com/assets.00/no-image-icon-512x512-lfoanl0w.png",
    onDismiss: () -> Unit,
    onDelete: () -> Unit
) {
    if (!show) return
    else {
        Dialog(onDismissRequest = {
            onDismiss()
        }) {
            Card(
                elevation = 8.dp, shape = RoundedCornerShape(8.dp)
            ) {

                Column(
                    Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Reserve Nº $reserveNumber",
                        style = MaterialTheme.typography.body1,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W700,
                        color = DarkGray
                    )
                    Text(
                        text = "Reserve Nº $tableNumber",
                        style = MaterialTheme.typography.body1,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W700,
                        color = DarkGray
                    )
                    Text(
                        text = "By $reservedBy",
                        style = MaterialTheme.typography.h2,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W700,
                        color = DarkGray
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        painter = rememberAsyncImagePainter(image),
                        contentDescription = "cover",
                        modifier = Modifier
                            .width(9000.dp)
                            .height(150.dp)

                    )
                    Spacer(modifier = Modifier.height(22.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onDismiss() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = "Cancel",
                                color = DarkGray,
                                fontSize = 15.sp,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.subtitle2
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onDelete() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painterResource(R.drawable.ic_delete),
                                tint = DarkGray,
                                contentDescription = "logo",
                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

