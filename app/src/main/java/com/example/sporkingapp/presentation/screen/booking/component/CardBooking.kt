package com.example.sporkingapp.presentation.screen.booking.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun CardBooking(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(0.1.dp, Color.Black, RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        // Bagian Atas (Oranye)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFD7900))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "SPORTHILL SPORT CENTRE",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        // Bagian Tengah (Abu-abu)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .background(Color(0xFFF3F3F3))
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_field),
                contentDescription = "icon",
                colorFilter = ColorFilter.tint(Color(0xFFFD7900)),
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Lapangan 2",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFD7900)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Sabtu, 3 Januari 2024",
                    fontSize = 12.sp,
                    color = Color(0xFFFD7900)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Pukul 18.00",
                    fontSize = 12.sp,
                    color = Color(0xFFFD7900)
                )
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .height(40.dp)
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD7900),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Chat Penyewa",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }

        // Bagian Bawah (Putih)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Lihat E-Tiket",
                color = Color(0xFFFD7900)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CardBookingPreview() {
    SporkingAppTheme {
        CardBooking()
    }
}
