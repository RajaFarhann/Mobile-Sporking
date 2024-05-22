package com.example.sporkingapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sporkingapp.presentation.component.BottomBar
import com.example.sporkingapp.presentation.homescreen.BerandaScreen
import com.example.sporkingapp.presentation.homescreen.CategoryFieldsScreen
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun SporkingApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "beranda"

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController, currentRoute = currentRoute)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(navController = navController, startDestination = "beranda") {
                composable("beranda") { BerandaScreen() }
                composable("category") { CategoryFieldsScreen() }
                composable("news") { BerandaScreen() }
                composable("booking") { BerandaScreen() }
                composable("komunitas") { BerandaScreen() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SporkingAppTheme {
        SporkingApp()
    }
}
