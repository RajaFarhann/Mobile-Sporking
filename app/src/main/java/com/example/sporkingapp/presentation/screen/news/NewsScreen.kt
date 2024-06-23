package com.example.sporkingapp.presentation.screen.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sporkingapp.R
import com.example.sporkingapp.data.local.dummy.DummyData
import com.example.sporkingapp.model.News
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.text.BoldTextOrangeComponent
import com.example.sporkingapp.presentation.screen.news.component.newsColumn

@Composable
fun newsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    berita: List<News> = DummyData.newsList
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "news"

    Scaffold (  ){innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Box (
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(
                        text = "News",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color(0xFFFD7900)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box (
                        modifier = Modifier
                            .fillMaxSize()
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
        }
    }
}