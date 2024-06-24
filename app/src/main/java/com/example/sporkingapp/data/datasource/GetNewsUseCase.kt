package com.example.sporkingapp.data.datasource

import com.example.sporkingapp.data.test.Result
import com.example.sporkingapp.repository.NewsRepository
import com.example.sporkingapp.utils.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject
import okio.IOException

class GetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend fun getNews(): Flow<ResourceState<List<Result>>> {
        return flow {
            try {
                emit(ResourceState.Loading())
                val news = newsRepository.getNews()
                emit(ResourceState.Success(news.results))
            } catch (e: HttpException) {
                emit(ResourceState.Error(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                emit(ResourceState.Error("Couldn't reach server. Check your internet connection"))
            }
        }
    }
}