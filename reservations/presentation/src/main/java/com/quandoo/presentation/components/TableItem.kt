package com.quandoo.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.model.Customer
import com.quandoo.presentation.R
import java.util.Locale

@Composable
fun TableItem(
    tableId: Int,
    customer: Customer?,
    shape: String,
    hasReserve: Boolean,
    onItemClick: (Int) -> Unit,

) {
    val imageResource = when (shape) {
        "circle" -> R.drawable.circle_table
        "square" -> R.drawable.square_table
        "rectangle" -> R.drawable.rectangle_table
        else -> R.drawable.rectangle_table
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(bottom = 8.dp)
            .drawBehind {
                drawLine(
                    color = Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )

            }

        ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { onItemClick(tableId) }
                .testTag("Table$tableId"),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
            ) {
                Image(
                    painter = rememberAsyncImagePainter(imageResource),
                    contentDescription = "cover",
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)

                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 10.dp, end = 20.dp, top = 0.dp, bottom = 0.dp)
            ) {
                Text(
                    text = "Table $tableId",
                    color = DarkGray,
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    fontWeight = Bold,
                    overflow = TextOverflow.Ellipsis
                    )
                Text(
                    text = shape.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    color = DarkGray,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = customer?.run { "Reserved by ${customer.firstName} ${customer.lastName}" }
                        ?: "FREE",
                    color = DarkGray,
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    fontWeight = Bold,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.testTag("ReserveBy$tableId"),
                )

            }
            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .height(100.dp)
                    .background(if (hasReserve) Red else Green)
                    .clip(RoundedCornerShape(100.dp))
                    .testTag("Box$tableId"),
            )
        }
    }
}

