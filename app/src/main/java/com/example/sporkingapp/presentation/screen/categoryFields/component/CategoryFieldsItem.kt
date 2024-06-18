package com.example.sporkingapp.presentation.screen.categoryFields.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.model.Category

@Composable
fun CategoryFieldsItem(category: Category) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .padding(vertical = 16.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = category.photo),
            contentDescription = category.name,
            modifier = Modifier
                .size(90.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Text(
            text = category.name,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFFD7900),
            modifier = Modifier.padding(start = 50.dp)
        )

    }
}