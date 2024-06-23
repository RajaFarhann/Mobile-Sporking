package com.example.sporkingapp.data.api

import com.example.sporkingapp.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apikey") apiKey: String = "6f0577ac4b78414384741e9d8da2958c"
    ): Response<NewsResponse>

}
// GET https://newsapi.org/v2/top-headlines?country=id&category=sports&apiKey=6f0577ac4b78414384741e9d8da2958c