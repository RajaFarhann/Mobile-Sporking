package com.example.sporkingapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.model.Category

@Composable
fun CategorySectionSearch(category: Category) {
    Column(
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(-20.dp) // Adjust spacing here
        ) {
            category.fields.forEach { field ->
                CardSearch(
                    field = field,
                )
            }
        }
    }
}