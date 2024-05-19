package com.example.sporkingapp.presentation.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.R
import com.example.sporkingapp.data.DummyData
import com.example.sporkingapp.model.Field
import com.example.sporkingapp.presentation.component.BottomBar
import com.example.sporkingapp.presentation.component.ButtonFilter
import com.example.sporkingapp.presentation.component.CardHome
import com.example.sporkingapp.presentation.component.SearchAndDropdown
import com.example.sporkingapp.presentation.component.TopBar
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerandaScreen(
    modifier: Modifier = Modifier,
    fields: List<Field> = DummyData.fields
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        modifier = modifier
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 120.dp)
                    .background(Color(0xFFF5F5F5))
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(307.dp)
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
                    .background(Color(0xFFFD7900))
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.image_banner),
                    contentDescription = "Banner",
                    modifier = Modifier
                        .size(width = 360.dp, height = 220.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(17.dp))
                SearchAndDropdown(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(30.dp))
                ButtonFilter(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    items(fields) { field ->
                        CardHome(
                            field = field,
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BerandaScreenPreview() {
    SporkingAppTheme {
        BerandaScreen()
    }
}
