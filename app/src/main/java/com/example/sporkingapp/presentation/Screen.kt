package com.example.sporkingapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.sporkingapp.presentation.homescreen.BerandaScreen
import com.example.sporkingapp.presentation.component.BottomBar
import com.example.sporkingapp.presentation.homescreen.CategoryFieldsScreen

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomBar(selectedTab = selectedTab, onTabSelected = { selectedTab = it })
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> BerandaScreen()
                1 -> CategoryFieldsScreen()
                // Add other cases for other screens here...
            }
        }
    }
}
