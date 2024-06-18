package com.example.sporkingapp.presentation.screen.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.sporkingapp.R
import com.example.sporkingapp.data.DummyData
import com.example.sporkingapp.model.News
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.bar.TopBar

@Composable
fun newsDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    berita: Int?

){
    val newestNewsList = DummyData.newsList.filter { news ->
        news.id == berita
    }

    Column (
        modifier = Modifier
    ){
        detailNewsContent(newestNewsList = newestNewsList, navController = navController, onNavigateToNewsScreen = { navController.navigate(
            Screen.NewsScreen.route) })
    }
}

@Composable
private fun detailNewsContent(
    newestNewsList: List<News>,
    modifier: Modifier = Modifier,
    onNavigateToNewsScreen: () -> Unit,
    navController: NavController
){

    Scaffold (
        topBar = {
            TopBar(
                showTitle = false,
                showBackButton = true,
                onBackClick = onNavigateToNewsScreen,
                showProfileImage = false,
                showChatIcon = false,
                showNotificationIcon = false
            )
        },
    ){innerPadding->
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(4.dp)
                .padding(innerPadding)
        ){
            Column (
                modifier = Modifier.fillMaxSize()
            ){
                Column (
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = newestNewsList[0].title, style = TextStyle(fontWeight = FontWeight.Medium),
                        color = colorResource(id = R.color.black), textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = newestNewsList[0].newsImageID)
                            .build(),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(height = 150.dp, width = 280.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentDescription = "News Detail"
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Column (modifier = Modifier.padding(4.dp)
                    ){
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = "(${newestNewsList[0].date})", color = Color.Gray)

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = newestNewsList[0].newsItemText, textAlign = TextAlign.Justify)
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun detailNewsContentPreview(){
//    detailNewsContent(newestNewsList = DummyData.newsList, navController = rememberNavController(), onNavigateToNewsScreen = { navController.navigate(Screen.NewsScreen.route) })
//}
