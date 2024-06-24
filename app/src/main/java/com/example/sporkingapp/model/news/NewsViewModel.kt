package com.example.sporkingapp.model.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sporkingapp.data.datasource.GetNewsUseCase
import com.example.sporkingapp.presentation.screen.news.NewsState
import com.example.sporkingapp.utils.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel(){

    private val _news = mutableStateOf(NewsState())
    val news: State<NewsState> = _news
    
    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            getNewsUseCase.getNews().collect { result ->
                when (result) {
                    is ResourceState.Success -> {
                        _news.value = NewsState(success = result.data ?: emptyList())
                    }

                    is ResourceState.Loading -> {
                        _news.value = NewsState(loading = true)
                    }

                    is ResourceState.Error -> {
                        _news.value =
                            NewsState(error = result.message ?: "An unexpected error occurred")
                    }
                }
            }
        }
    }

}