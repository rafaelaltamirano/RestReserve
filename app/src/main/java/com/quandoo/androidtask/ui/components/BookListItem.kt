package com.quandoo.androidtask.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.quandoo.androidtask.ui.theme.DarkGreen

@Composable
fun TableItem(
    tableId: Long,
    reservedBy: String,
    shape: String

) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(bottom = 8.dp)
            .drawBehind {
                drawLine(
                    color = Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }, backgroundColor = DarkGreen
    ) {
        Row() {
            Image(
                painter = rememberAsyncImagePainter("https://images.blinkist.com/images/books/5694b3802f6827000700002a/3_4/640.jpg"),
                contentDescription = "cover",
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 10.dp, end= 20.dp,top = 0.dp, bottom = 0.dp)
            ) {
                Text(
                    text = "231",
                    color = White,
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,

                )
                Text(
                    text = "paul",
                    color = White,
                    style = MaterialTheme.typography.body1,
                )

            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewItemList() {
//    val book: Book = Book(
//        "Tom Rath",
//        "Ernesto Sabato",
//        "25-06-1997",
//        "https://images.blinkist.com/images/books/5694b3802f6827000700002a/3_4/640.jpg",
//        "23312"
//    )
//    BookListItem(book)
//}

