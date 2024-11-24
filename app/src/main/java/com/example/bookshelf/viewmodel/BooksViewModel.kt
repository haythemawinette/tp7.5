package com.example.bookshelf.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.network.BookItem
import com.example.bookshelf.repository.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(private val repository: BooksRepository) : ViewModel() {
    val books = mutableStateOf<List<BookItem>>(emptyList())
    val isLoading = mutableStateOf(false)

    fun searchBooks(query: String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                books.value = repository.searchBooks(query)
            } catch (e: Exception) {
                books.value = emptyList()
            }
            isLoading.value = false
        }
    }
}
