package com.example.sporkingapp.data.datasource

import com.example.sporkingapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

   suspend fun getNewsHeadline(country: String) : Response<NewsResponse>

}