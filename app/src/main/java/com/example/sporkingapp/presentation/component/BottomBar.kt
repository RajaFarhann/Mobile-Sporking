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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sporkingapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(
    navController: NavController,
    currentRoute: String
) {
    val orangeColor = Color(0xFFFD7900)
    val textColor = Color(0xFF8F8C95)

    BottomAppBar(
        containerColor = Color.White,
        contentColor = orangeColor, // Warna latar belakang bottom app bar
        contentPadding = PaddingValues(16.dp) // Padding konten dalam bottom app bar
    ) {
        IconButton(
            onClick = { navController.navigate("beranda") },
            modifier = Modifier.weight(1f)
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
                    colorFilter = ColorFilter.tint(if (currentRoute == "beranda") orangeColor else textColor)
                )
                Text(
                    text = "Beranda",
                    fontSize = 10.sp,
                    color = if (currentRoute == "beranda") orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { navController.navigate("category") },
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
                    colorFilter = ColorFilter.tint(if (currentRoute == "category") orangeColor else textColor)
                )
                Text(
                    text = "Lapangan",
                    fontSize = 10.sp,
                    color = if (currentRoute == "category") orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { navController.navigate("news") },
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
                    colorFilter = ColorFilter.tint(if (currentRoute == "news") orangeColor else textColor)
                )
                Text(
                    text = "News",
                    fontSize = 10.sp,
                    color = if (currentRoute == "news") orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { navController.navigate("booking") },
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
                    colorFilter = ColorFilter.tint(if (currentRoute == "booking") orangeColor else textColor)
                )
                Text(
                    text = "Pemesanan",
                    fontSize = 10.sp,
                    color = if (currentRoute == "booking") orangeColor else textColor
                )
            }
        }

        IconButton(
            onClick = { navController.navigate("komunitas") },
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
                    colorFilter = ColorFilter.tint(if (currentRoute == "komunitas") orangeColor else textColor)
                )
                Text(
                    text = "Komunitas",
                    fontSize = 10.sp,
                    color = if (currentRoute == "komunitas") orangeColor else textColor
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BottomBarPreview() {
//    SporkingAppTheme {
//        BottomBar() {}
//    }
//}
