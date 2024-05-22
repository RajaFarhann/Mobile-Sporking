package com.example.sporkingapp.presentation.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.data.DummyData
import com.example.sporkingapp.model.Category
import com.example.sporkingapp.presentation.component.ButtonFilter
import com.example.sporkingapp.presentation.component.CategorySection
import com.example.sporkingapp.presentation.component.SearchAndDropdown
import com.example.sporkingapp.presentation.component.TopBar
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerandaScreen(
    modifier: Modifier = Modifier,
    categories: List<Category> = DummyData.categories
) {
    Scaffold(
        topBar = { TopBar() },
//        bottomBar = { BottomBar(selectedTab = selectedTab, onTabSelected = { selectedTab = it }) },
        modifier = modifier
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 120.dp)
                    .background(Color(0xFFF5F5F5))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(307.dp)
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                    .background(Color(0xFFFD7900))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.image_banner),
                    contentDescription = "Banner",
                    modifier = Modifier
                        .size(width = 360.dp, height = 220.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(17.dp))
                SearchAndDropdown(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(30.dp))
                ButtonFilter(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(7.dp))
                Row (
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Rekomendasi untuk kamu",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFD7900),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black // Warna teks dan ikon
                        ),
                        modifier = Modifier.height(45.dp)
                    ) {
                        Text(
                            text = "Lihat Semua",
                            fontSize = 14.sp,
                            color = Color(0xFFFD7900)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Image(
                            painter = painterResource(id = R.drawable.icon_arrow_circle),
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .size(18.dp)
                        )
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(categories) { category ->
                        CategorySection(category)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BerandaScreenPreview() {
    SporkingAppTheme {
        BerandaScreen()
    }
}
