package com.example.sporkingapp.presentation.screen.categoryFields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.data.DummyData
import com.example.sporkingapp.model.Category
import com.example.sporkingapp.presentation.screen.categoryFields.component.CategoryFieldsItem
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun CategoryFieldsScreen(
    modifier: Modifier = Modifier,
    categories: List<Category> = DummyData.categories
) {

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color(0xFFF5F5F5))
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "Kategori",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xFFFD7900)
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp) // Adjust spacing here
                ) {
                    items(categories) { category ->
                        CategoryFieldsItem(category)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CategoryFieldsScreenPreview() {
    SporkingAppTheme {
        CategoryFieldsScreen()
    }
}