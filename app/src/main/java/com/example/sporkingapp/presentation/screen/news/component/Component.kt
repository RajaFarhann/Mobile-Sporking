package com.example.sporkingapp.presentation.screen.news.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sporkingapp.data.entity.Article
import com.example.sporkingapp.data.entity.NewsResponse
import com.example.sporkingapp.data.test.Result

@Composable
fun Loader(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .padding(20.dp),
            color = Color.Gray
        )
    }
}

@Composable
fun NewsList(response: NewsResponse){
    LazyColumn (

    ){
        items(response.articles){ article ->
            Text(text = article.title ?: "NA")
        }
    }
}

@Composable
fun NewsRowComp(page: Int, article: Result){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .wrapContentHeight(),
            model = article.image_url,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = article.title ?:  "", textAlign = TextAlign.Center, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = article.description ?:  "", textAlign = TextAlign.Justify, style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(250.dp))

    }
}

