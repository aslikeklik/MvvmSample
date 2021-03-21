package com.example.mvvmsample.data.model

import com.google.gson.annotations.SerializedName

data class BookModel(
    @SerializedName("userId")
    val userId: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("completed")
    val completed: Boolean = true
)