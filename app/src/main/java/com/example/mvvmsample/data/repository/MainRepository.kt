package com.example.mvvmsample.data.repository

import com.example.mvvmsample.data.api.ApiHelper
import com.example.mvvmsample.data.model.BookModel
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getBooks(): Single<List<BookModel>> {
        return apiHelper.getBooks()
    }

}