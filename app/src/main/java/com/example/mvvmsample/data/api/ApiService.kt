package com.example.mvvmsample.data.api

import com.example.mvvmsample.data.model.BookModel
import io.reactivex.Single

interface ApiService {

    fun getBooks(): Single<List<BookModel>>
}