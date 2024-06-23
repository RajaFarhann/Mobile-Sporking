package com.example.sporkingapp.presentation.screen.NEWS

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sporkingapp.data.entity.Article
import com.example.sporkingapp.model.news.NewsViewModel
import com.example.sporkingapp.model.news.NewsViewModel.Companion.TAG
import com.example.sporkingapp.presentation.screen.NEWS.component.Loader
import com.example.sporkingapp.presentation.screen.NEWS.component.NewsRowComponent
import com.example.sporkingapp.utils.ResourceState

const val TAG = "NewsScreen"
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsScreen(
    newsViewModel: NewsViewModel = hiltViewModel(),
    article: Article
){

    val newsRes = newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState (
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ){
        100
    }


    VerticalPager(state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ){page:Int ->
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
            ){
                Text(text = "Test")
                Spacer(modifier = Modifier.height(48.dp))

                when(newsRes){
                    is ResourceState.Loading -> {
                        Log.d(TAG, "Inside_Loading")
                        Loader()
                    }

                    is ResourceState.Success -> {
                        val response = (newsRes as ResourceState.Success).data
                        Log.d(TAG, "Inside_Success ${response.status} = ${response.totalResult}")

                        if (response.articles.isNotEmpty()){
                            NewsRowComponent(page, response.articles[page])
                        }

                    }

                    is ResourceState.Error -> {
                        val error = (newsRes as ResourceState.Error)
                        Log.d(TAG, "Inside_Error $error")
                    }
                }
            }
        }
    }


}



//@Preview
//@Composable
//fun NewsScreenPreveiw(){
//    NewsScreen()
//}