package com.example.mvvmsample.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getBooks() = apiService.getBooks()

}