package com.example.bookshelf.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BooksResponse

    @GET("volumes/{volumeId}")
    suspend fun getBookDetails(@Path("volumeId") volumeId: String): BookDetailsResponse
}
