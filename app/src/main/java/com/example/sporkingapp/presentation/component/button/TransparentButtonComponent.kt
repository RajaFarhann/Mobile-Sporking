package com.example.sporkingapp.presentation.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R

@Composable
fun TransparentButtonComponent(value: String, image: Painter, onTaskClick: () -> Unit){
    OutlinedButton(
        onClick = onTaskClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        border = BorderStroke(0.dp, Color.Transparent),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp),
            contentAlignment = Alignment.Center,
        ){
            Image(modifier = Modifier.padding(end = 320.dp),painter = image, contentDescription = "")
            Text(text = value,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn()
                    .padding(start = 50.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Normal
                ),
                color = colorResource(id = R.color.orange_7900),
                textAlign = TextAlign.Start
            )
            Image(modifier = Modifier.padding(start = 320.dp), painter = painterResource(id = R.drawable.icon_rightarrow), contentDescription = "")
        }
    }
}