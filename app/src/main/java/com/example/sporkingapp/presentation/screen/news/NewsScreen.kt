

package com.example.sporkingapp.presentation.screen.news

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sporkingapp.model.news.NewsViewModel
import com.example.sporkingapp.presentation.screen.news.component.Loader
import com.example.sporkingapp.presentation.screen.news.component.NewsRowComp
import com.example.sporkingapp.presentation.screen.news.component.newsColumn


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsScreen(
    newsViewModel: NewsViewModel = hiltViewModel(),
) {

    val state = newsViewModel.news.value

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        state.success.size
    }


    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (state.loading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                } else if (state.error.isNotEmpty()) {
                    Text(
                        text = state.error,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                } else {
                    state.success.getOrNull(page)?.let { article ->
                        NewsRowComp(page = page, article = article)
                    }
                }
            }
        }
    }

}