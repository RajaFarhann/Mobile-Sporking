package com.example.sporkingapp.model

data class News(
    val id: Int,
    val title: String,
    val date: String,
    val newsItemText: String,
    val newsImageID: Int = 0
)
