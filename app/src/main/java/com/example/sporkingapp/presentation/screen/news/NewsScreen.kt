package com.example.sporkingapp.presentation.screen.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.data.local.dummy.DummyData
import com.example.sporkingapp.model.News
import com.example.sporkingapp.presentation.screen.news.component.newsColumn

@Composable
fun newsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    berita: List<News> = DummyData.newsList
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    Scaffold (
    ){innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
        ){
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ){
                items(berita, key = {it.id}){
                    newsColumn(news = it) { newsId ->
                        navController.navigate(Screen.NewsDetail.route + "/$newsId")
                    }
                }
            }
        }

    }
}