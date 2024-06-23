package com.example.sporkingapp.model.news

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sporkingapp.data.AppConstrants
import com.example.sporkingapp.data.entity.NewsResponse
import com.example.sporkingapp.repository.NewsRepository
import com.example.sporkingapp.utils.ResourceState
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Locale.IsoCountryCode
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel(){

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        getNews(AppConstrants.COUNTRY)
    }

    private fun getNews(country: String){
        viewModelScope.launch (Dispatchers.IO){
            newsRepository.getNewsHeadline(country)
                .collectLatest {newsResponse ->
                    _news.value = newsResponse
                }
        }
    }

    companion object{
        const val TAG = "NewsViewModel"
    }

}