package com.example.bookshelf.data

import com.example.bookshelf.network.GoogleBooksApi
import com.example.bookshelf.repository.BooksRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val booksRepository: BooksRepository
}

class BooksRepository : AppContainer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val googleBooksApiService = retrofit.create(GoogleBooksApi::class.java)

    override val booksRepository: BooksRepository = BooksRepository(googleBooksApiService)
}
