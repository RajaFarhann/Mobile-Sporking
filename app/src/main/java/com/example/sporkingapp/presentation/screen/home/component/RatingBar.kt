package com.example.sporkingapp.presentation.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun RatingBar(
    rating: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        for (i in 1..5) {
            val image = if (i <= rating) {
                R.drawable.icon_star_filled_orange
            } else {
                R.drawable.icon_star_outlined
            }
            Image(
                painter = painterResource(id = image),
                contentDescription = "Star",
                modifier = Modifier.size(10.dp)
            )
        }
    }
}

@Preview
@Composable
fun RatingBarPreview() {
    SporkingAppTheme {
        RatingBar(rating = 3)
    }
}