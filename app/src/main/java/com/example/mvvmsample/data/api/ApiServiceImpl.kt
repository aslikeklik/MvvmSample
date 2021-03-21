package com.example.mvvmsample.data.api

import com.example.mvvmsample.data.model.BookModel
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl: ApiService {
    override fun getBooks(): Single<List<BookModel>> {
        return Rx2AndroidNetworking.get("https://jsonplaceholder.typicode.com/todos")
            .build()
            .getObjectListSingle(BookModel::class.java)
    }
}