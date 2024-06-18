package com.example.sporkingapp.presentation.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.ui.theme.mainOrange
import com.example.sporkingapp.ui.theme.secondButton

@Composable
fun GoogleButtonComponent(value: String, image: Painter, onTaskClick: () -> Unit){
    Button(
        onClick = onTaskClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(secondButton)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    color = secondButton
                ),
            contentAlignment = Alignment.Center,
        ){
            Image(modifier = Modifier.padding(end = 280.dp),painter = image, contentDescription = "")
            Text(text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = mainOrange
            )
        }
    }

}