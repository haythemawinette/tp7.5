package com.example.bookshelf.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookshelf.viewmodel.BooksViewModel

@Composable
fun BooksScreen(viewModel: BooksViewModel) {
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search books...") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (viewModel.isLoading.value) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            BooksGrid(books = viewModel.books.value)
        }
    }

    LaunchedEffect(query) {
        if (query.isNotEmpty()) {
            viewModel.searchBooks(query)
        }
    }
}
