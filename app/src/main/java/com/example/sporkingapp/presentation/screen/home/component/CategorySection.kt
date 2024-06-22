//package com.example.sporkingapp.presentation.screen.home.component
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.sporkingapp.model.Category
//
//@Composable
//fun CategorySection(
//    category: Category,
//    onNavigateToDetailField: () -> Unit
//) {
//    Column() {
//        Text(
//            text = category.name,
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFFFD7900),
//            modifier = Modifier.padding(horizontal = 8.dp)
//        )
//        LazyRow(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(-20.dp)
//        ) {
//            items(category.fields) { field ->
//                CardHome(
//                    field = field,
//                    modifier = Modifier
//                        .padding(vertical = 8.dp),
//                    onNavigateToDetailField = onNavigateToDetailField
//                )
//            }
//        }
//    }
//}