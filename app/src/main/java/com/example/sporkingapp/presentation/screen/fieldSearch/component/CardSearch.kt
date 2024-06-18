package com.example.sporkingapp.presentation.screen.fieldSearch.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.model.Field
import com.example.sporkingapp.presentation.screen.home.component.RatingBar
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun CardSearch(
    field: Field,
    modifier: Modifier = Modifier,
//    onItemClicked: (Int) -> Unit
) {
    val warna = 0xFFFD7900

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 120.dp, height = 120.dp)
            ) {
                Image(
                    painter = painterResource(id = field.photo),
                    contentDescription = field.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .align(Alignment.Center)
                )
                Text(
                    text = "${field.distance} KM",
                    fontSize = 8.sp,
                    color = Color(warna),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = field.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(warna),
                )
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingBar(
                        rating = field.rating,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)

                    )
                    Text(
                        text = "Rp.${field.price}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(warna),
                    )
                }
            }
        }
        Divider(color = Color(0xFFDFDFDF), thickness = 1.dp)
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "Available",
                fontSize = 12.sp,
                color = Color(warna),
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CardSearchPreview() {
    SporkingAppTheme {
        CardSearch(
            field = Field(
                id = 1,
                name = "Lapangan Futsal Ikan Daun",
                price = "167.000,00",
                distance = 0.1,
                rating = 5,
                photo = R.drawable.lapangan_futsal_ikan_daun,
            )
        )
    }
}
