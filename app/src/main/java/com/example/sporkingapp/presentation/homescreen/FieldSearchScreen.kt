package com.example.sporkingapp.presentation.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.data.DummyData
import com.example.sporkingapp.model.Category
import com.example.sporkingapp.presentation.component.CategorySectionSearch
import com.example.sporkingapp.presentation.component.TopBar
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun FieldSearchScreen(
    modifier: Modifier = Modifier,
    categories: List<Category> = DummyData.categories
) {
    Scaffold(
        topBar = {
            TopBar(
                showTitle = false,
                showBackButton = true,
                onBackClick = { /* TODO: Handle back button click */ },
                showProfileImage = false,
                showChatIcon = false,
                showNotificationIcon = false
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color(0xFFFD7900))
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 5.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color(0xFFF5F5F5))
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(-20.dp) // Adjust spacing here
                ) {
                    items(categories) { category ->
                        CategorySectionSearch(category)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FieldSearchScreenPreview() {
    SporkingAppTheme {
        FieldSearchScreen()
    }
}