package com.example.sporkingapp.presentation.screen.news.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sporkingapp.R
import com.example.sporkingapp.data.test.Result
import com.example.sporkingapp.model.News
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun newsColumn(
    page: Int, article: Result,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
//            .clickable { onItemClicked(news.id) }
    ){
        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Row (
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){

                AsyncImage(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    model = article.image_url,
                    contentScale = ContentScale.Crop,
                    contentDescription = "")
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column {
                    Text(text = article.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
                        Text(text = article.pubDate, color = Color.Gray)
                    }
                }


//                AsyncImage(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(240.dp)
//                        .wrapContentHeight(),
//                    model = article.image_url,
//                    contentDescription = "",
//                    contentScale = ContentScale.Crop
//                )

//                Image(painter = painterResource(id = news.newsImageID),
//                    contentDescription = news.title,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(120.dp)
//                        .clip(RoundedCornerShape(8.dp))
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//                Column {
//                    Text(text = news.title, style = MaterialTheme.typography.titleMedium)
//                    Spacer(modifier = Modifier.height(12.dp))
//                    Row {
////                Text(text = news.date)
//                        Text(text = "- ${news.date}", color = Color.Gray)
//                    }
//                }
            }

        }

    }
}