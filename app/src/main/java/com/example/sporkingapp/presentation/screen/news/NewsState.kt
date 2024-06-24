package com.example.sporkingapp.presentation.screen.news

import com.example.sporkingapp.data.test.Result

data class NewsState(
    val success: List<Result> = emptyList(),
    val loading: Boolean = false,
    val error: String = ""
)
