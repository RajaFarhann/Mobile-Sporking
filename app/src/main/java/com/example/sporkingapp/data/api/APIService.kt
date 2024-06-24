package com.example.sporkingapp.data.api

import com.example.sporkingapp.data.entity.NewsResponse
import com.example.sporkingapp.data.test.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("api/1/latest")
    suspend fun getNews(
        @Query("apikey") apiKey: String = "pub_472069f07037c2442e84ae2be4ca3c8f6cbcb",
        @Query("q") q: String = "sport",
        @Query("language") category: String = "id"
    ): News


}
// GET https://newsapi.org/v2/top-headlines?country=id&category=sports&apiKey=6f0577ac4b78414384741e9d8da2958c