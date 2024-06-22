package com.example.sporkingapp.presentation.screen.home.component
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.example.sporkingapp.model.Field

@Composable
fun CardHome(
    field: Field,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    var warna = 0xFFFD7900

    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .clickable {onItemClicked(field.id)}
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = field.photo),
                    contentDescription = field.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(
                            width = 200.dp,
                            height = 160.dp
                        )
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = field.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(warna),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 6.dp, end = 6.dp)
                )
                Row (
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 5.dp
                    ),
                    horizontalArrangement = Arrangement
                        .spacedBy(40.dp)
                ) {
                    RatingBar(
                        rating = field.rating,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)

                    )
                    Text(
                        text = "Rp.${field.price}",
                        fontSize = 12.sp,
                        color = Color(warna),
                        modifier = Modifier
                    )
                }
            }
            Text(
                text = "${field.distance} KM",
                fontSize = 12.sp,
                color = Color(warna),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(22.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}

//@Preview(showBackground = false)
//@Composable
//fun CardHomePreview() {
//    SporkingAppTheme {
//        CardHome(
////            onNavigateToDetailField = onNavigateToDetailField,
//            field = Field(
//                id = 1,
//                name = "Lapangan Futsal Ikan Daun",
//                price = "167.000,00",
//                distance = 0.1,
//                rating = 5,
//                photo = R.drawable.lapangan_futsal_ikan_daun,
//                category = "Futsal"
//            )
//        )
//    }
//}