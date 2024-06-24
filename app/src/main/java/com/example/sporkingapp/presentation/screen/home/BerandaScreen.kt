package com.example.sporkingapp.presentation.screen.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sporkingapp.R
import com.example.sporkingapp.data.local.dummy.DummyData
import com.example.sporkingapp.model.Field
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.bar.TopBar
import com.example.sporkingapp.presentation.screen.home.component.ButtonFilter
import com.example.sporkingapp.presentation.screen.home.component.CardHome
import com.example.sporkingapp.presentation.screen.home.component.SearchAndDropdown

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerandaScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    lapangan: List<Field> = DummyData.FieldList,
    onNavigateToFieldSearch: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "field"

    val futsalLapangan = lapangan.filter { it.category == "Futsal" }
    Scaffold(
        topBar = { TopBar(
            onProfileClick = onNavigateToProfile,
        ) },
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
                    modifier = Modifier.padding(start = 25.dp)
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
                        onClick = onNavigateToFieldSearch,
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
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(0.dp),
                ) {
                    items(futsalLapangan, key = { it.id }) { field ->
                        CardHome(field = field) { selectedField ->
                            navController.navigate(Screen.Detail.route + "/${selectedField}")
                        }
                    }
                }
            }
        }
    }
}