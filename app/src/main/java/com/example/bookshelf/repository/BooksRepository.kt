package com.example.bookshelf.repository

import com.example.bookshelf.network.BookDetailsResponse
import com.example.bookshelf.network.BookItem
import com.example.bookshelf.network.GoogleBooksApi

class BooksRepository(private val api: GoogleBooksApi) {
    suspend fun searchBooks(query: String): List<BookItem> {
        return api.searchBooks(query).items
    }

    suspend fun getBookDetails(volumeId: String): BookDetailsResponse {
        return api.getBookDetails(volumeId)
    }

}
