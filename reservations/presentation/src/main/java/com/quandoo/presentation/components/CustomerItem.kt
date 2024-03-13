package com.quandoo.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.model.Customer

@Composable
fun CustomerItem(
    customer: Customer,
    onItemClick: (Int) -> Unit

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(bottom = 8.dp)
            .drawBehind {
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            },

        ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { onItemClick(customer.id) },
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Box(
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
            ) {
                Image(
                    painter = rememberAsyncImagePainter(customer?.imageUrl),
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
                    text = customer?.firstName + " " + customer?.lastName,
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,

                    )

            }
        }
    }
}

