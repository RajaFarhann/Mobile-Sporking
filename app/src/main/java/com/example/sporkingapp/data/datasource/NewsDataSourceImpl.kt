package com.example.sporkingapp.data.datasource

import com.example.sporkingapp.data.api.APIService
import com.example.sporkingapp.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: APIService
): NewsDataSource {

    override suspend fun getNewsHeadline(country: String) : Response<NewsResponse>{
        return  apiService.getNewsHeadline(country)
    }

}