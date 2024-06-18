package com.example.sporkingapp.presentation.screen.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun ButtonFilter(
    modifier: Modifier = Modifier
) {
    var buttonHeight = 40.dp
    val defaultColor = Color(0xFFDFDFDF)
    val selectedColor = Color(0xFFFD7900)

    var selectedButton by remember { mutableStateOf(1) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { selectedButton = 1 },
            modifier = Modifier
                .height(buttonHeight)
                .wrapContentWidth(),
            colors = ButtonDefaults.buttonColors(if (selectedButton == 1) selectedColor else defaultColor),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Terdekat",
                fontSize = 12.sp,
                color = Color.White
            )
        }
        Button(
            onClick = { selectedButton = 2 },
            modifier = Modifier
                .height(buttonHeight)
                .wrapContentWidth(),
            colors = ButtonDefaults.buttonColors(if (selectedButton == 2) selectedColor else defaultColor),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "Termurah",
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ButtonFilterPreview() {
    SporkingAppTheme {
        ButtonFilter()
    }
}