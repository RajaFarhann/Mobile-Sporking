package com.example.sporkingapp.data.datasource

import com.example.sporkingapp.data.api.APIService
import com.example.sporkingapp.data.entity.NewsResponse
import com.example.sporkingapp.data.test.News
import com.example.sporkingapp.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : NewsRepository {
    override suspend fun getNews(): News {
        return apiService.getNews()
    }
}