package com.example.sporkingapp.repository

import com.example.sporkingapp.data.datasource.NewsDataSource
import com.example.sporkingapp.data.entity.NewsResponse
import com.example.sporkingapp.utils.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
){

//    suspend fun getNewsHeadline(country: String) : Response<NewsResponse>{
//        return newsDataSource.getNewsHeadline(country)
//    }

    suspend fun getNewsHeadline(country: String): Flow<ResourceState<NewsResponse>>{
        return flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getNewsHeadline(country)

            if (response.isSuccessful && response.body() !=null){
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error News Data"))
            }
        }.catch { exception ->
            emit(ResourceState.Error(exception?.localizedMessage ?: "Some Error in flow"))
        }
    }

}