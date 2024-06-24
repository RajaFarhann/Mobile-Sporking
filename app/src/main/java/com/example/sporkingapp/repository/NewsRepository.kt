package com.example.sporkingapp.repository

import com.example.sporkingapp.data.entity.NewsResponse
import com.example.sporkingapp.data.test.News

interface NewsRepository {

    suspend fun getNews(): News

}