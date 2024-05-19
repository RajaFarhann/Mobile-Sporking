package com.example.sporkingapp.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sporkingapp.presentation.homescreen.BerandaScreen
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SporkingApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    BerandaScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SporkingAppTheme {
        SporkingApp()
    }
}
