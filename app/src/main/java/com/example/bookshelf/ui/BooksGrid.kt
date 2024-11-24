package com.example.bookshelf.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.network.BookItem

@Composable
fun BooksGrid(books: List<BookItem>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(books.size) { index ->
            val book = books[index]
            Column(
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = book.volumeInfo.imageLinks?.thumbnail?.replace("http", "https"),
                    contentDescription = book.volumeInfo.title,
                    modifier = Modifier
                        .size(128.dp)
                        .padding(4.dp)
                )
                Text(
                    text = book.volumeInfo.title,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
