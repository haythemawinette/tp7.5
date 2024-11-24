package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.network.RetrofitInstance
import com.example.bookshelf.repository.BooksRepository
import com.example.bookshelf.ui.BooksScreen
import com.example.bookshelf.viewmodel.BooksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = BooksRepository(RetrofitInstance.api)
        val viewModel = BooksViewModel(repository)

        setContent {
            BooksScreen(viewModel = viewModel)
        }
    }
}
