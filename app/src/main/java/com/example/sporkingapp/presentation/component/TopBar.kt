package com.example.sporkingapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = "Halo, Aan",
                    color = Color.White,
                    fontSize = 18.sp
                    )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle bell icon click */ }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_chat ),
                    contentDescription = "Notification",
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = { /* TODO: Handle bell icon click */ }) {
                Image(
                    painter = painterResource(id = R.drawable.icon_notification ),
                    contentDescription = "Notification",
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFD7900))
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SporkingAppTheme {
        TopBar()
    }
}