package com.example.sporkingapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar() {
    val orangeColor = Color(0xFFFD7900)
    val textColor = Color(0xFF8F8C95)

    var selectedTab by remember { mutableStateOf(0) }

    BottomAppBar(
        containerColor = Color.White,
        contentColor = orangeColor, // Warna latar belakang bottom app bar
        contentPadding = PaddingValues(16.dp) // Padding konten dalam bottom app bar
    ) {
        IconButton(
            onClick = { selectedTab = 0 },
            modifier = Modifier.weight(1f) // Memastikan tombol memenuhi lebar yang sama
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (selectedTab == 0) orangeColor else textColor)
                )
                Text(
                    text = "Beranda",
                    fontSize = 10.sp,
                    color = if (selectedTab == 0) orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { selectedTab = 1 },
            modifier = Modifier.weight(1f) // Memastikan tombol memenuhi lebar yang sama
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_field),
                    contentDescription = "Field",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (selectedTab == 1) orangeColor else textColor)
                )
                Text(
                    text = "Lapangan",
                    fontSize = 10.sp,
                    color = if (selectedTab == 1) orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { selectedTab = 2 },
            modifier = Modifier.weight(1f) // Memastikan tombol memenuhi lebar yang sama
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_soccer_ball),
                    contentDescription = "News",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (selectedTab == 2) orangeColor else textColor)
                )
                Text(
                    text = "News",
                    fontSize = 10.sp,
                    color = if (selectedTab == 2) orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { selectedTab = 3 },
            modifier = Modifier.weight(1f) // Memastikan tombol memenuhi lebar yang sama
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_calender),
                    contentDescription = "Pemesanan",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (selectedTab == 3) orangeColor else textColor)
                )
                Text(
                    text = "Pemesanan",
                    fontSize = 10.sp,
                    color = if (selectedTab == 3) orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { selectedTab = 4 },
            modifier = Modifier.weight(1f) // Memastikan tombol memenuhi lebar yang sama
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(), // Atau sesuaikan dengan kebutuhan
                horizontalAlignment = Alignment.CenterHorizontally, // Menjadikan semua anak di dalam Column terpusat secara horizontal
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_person),
                    contentDescription = "Komunitas",
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(if (selectedTab == 4) orangeColor else textColor)
                )
                Text(
                    text = "Komunitas",
                    fontSize = 10.sp,
                    color = if (selectedTab == 4) orangeColor else textColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    SporkingAppTheme {
        BottomBar()
    }
}
