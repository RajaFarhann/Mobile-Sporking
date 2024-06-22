package com.example.sporkingapp.presentation.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sporkingapp.R
import com.example.sporkingapp.data.local.dummy.DummyData
import com.example.sporkingapp.model.Field
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.bar.TopBar
import com.example.sporkingapp.presentation.screen.home.component.RatingBar

@Composable
fun FieldDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    lapangan: Int?

){
    val newLapanganList = DummyData.FieldList.filter { field ->
        field.id == lapangan
    }

    Column (
        modifier = Modifier
    ){
        FieldDetailContent(newLapanganList = newLapanganList, navController = navController, onNavigateToBerandaScreen = { navController.navigate(Screen.Beranda.route) })
    }
}

@Composable
private fun FieldDetailContent(
    newLapanganList: List<Field>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onNavigateToBerandaScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                showTitle = false,
                showBackButton = true,
                onBackClick = onNavigateToBerandaScreen,
                showProfileImage = false,
                showChatIcon = false,
                showNotificationIcon = false
            )
        },
        bottomBar = {
            BottomBarDetail(navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Image(
                painter = painterResource(id = R.drawable.detail_lapangan),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 200.dp)
                    .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                    .background(Color(0xFFF5F5F5))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(220.dp))
                Row (
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = newLapanganList[0].name,
                        fontSize = 20.sp,
                        color = Color(0xFFFD7900),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.width(160.dp))
                    Text(
                        text = "1.6KM",
                        fontSize = 12.sp,
                        color = Color(0xFFFD7900),
                        modifier = Modifier
                            .background(Color(0x238F8C95), shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                RatingBar(
                    rating = 5,
                    modifier = Modifier
                        .padding(start = 40.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.detail_maps),
                    contentDescription = "Banner",
                    modifier = Modifier
                        .size(width = 360.dp, height = 200.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            navController.navigate(Screen.Maps.route)
                        }
                )
                Divider(
                    color = Color(0xFFDFDFDF),
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .height(40.dp)
                            .wrapContentWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Terdekat",
                            fontSize = 12.sp,
                            color = Color(0xD08F8C95)
                        )
                    }
                    Spacer(modifier = Modifier.width(80.dp))
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .height(40.dp)
                            .wrapContentWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Termurah",
                            fontSize = 12.sp,
                            color = Color(0xD08F8C95)
                        )
                    }
                }
                Divider(
                    color = Color(0xFFDFDFDF),
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Image(
                    painter = painterResource(id = R.drawable.detail_fasilitas),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 300.dp, height = 200.dp)
                        .offset(x = 40.dp)
                )
            }
        }
    }
}

@Composable
fun BottomBarDetail(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Harga Lapangan Perjam",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFD7900)
                )
                Text(
                    text = "Rp.150.000",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFD7900)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Handle button click */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD7900) // Orange color
                ),
                modifier = Modifier
                    .width(320.dp)
                    .height(41.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Sewa Sekarang",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}
