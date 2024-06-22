package com.example.sporkingapp.presentation.screen.fieldSearch

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
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.sporkingapp.data.local.dummy.DummyData
import com.example.sporkingapp.model.Field
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.bar.TopBar
import com.example.sporkingapp.presentation.screen.fieldSearch.component.CardSearch

@Composable
fun FieldSearchScreen(
    modifier: Modifier = Modifier,
    field: List<Field> = DummyData.FieldList,
    onNavigateToBerandaScreen: () -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(
                showTitle = false,
                showBackButton = true,
                onBackClick = onNavigateToBerandaScreen,
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
                    items(field, key = {it.id}) {
                        CardSearch(
                            field = it
                        ){ fieldId ->
                            navController.navigate(Screen.Detail.route + "/$fieldId")
                        }
                    }
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun FieldSearchScreenPreview() {
//    SporkingAppTheme {
//        FieldSearchScreen()
//    }
//}
