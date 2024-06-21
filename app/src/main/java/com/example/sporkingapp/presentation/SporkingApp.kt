package com.example.sporkingapp.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.bar.BottomBar
import com.example.sporkingapp.presentation.screen.agreement.AgreementScreen
import com.example.sporkingapp.presentation.screen.booking.BookingScreen
import com.example.sporkingapp.presentation.screen.categoryFields.CategoryFieldsScreen
import com.example.sporkingapp.presentation.screen.detail.DetailScreen
import com.example.sporkingapp.presentation.screen.fieldSearch.FieldSearchScreen
import com.example.sporkingapp.presentation.screen.home.BerandaScreen
import com.example.sporkingapp.presentation.screen.login.LoginScreen
import com.example.sporkingapp.presentation.screen.news.newsDetailScreen
import com.example.sporkingapp.presentation.screen.news.newsScreen
import com.example.sporkingapp.presentation.screen.onboarding.OnboardingScreen
import com.example.sporkingapp.presentation.screen.profile.ProfileScreen
import com.example.sporkingapp.presentation.screen.signup.signUpScreen
import com.example.sporkingapp.presentation.screen.splash.SplashScreen
import com.example.sporkingapp.ui.theme.SporkingAppTheme
import com.example.sporkingapp.utils.shouldShowBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SporkingApp() {
    val navController = rememberNavController()
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ){
                BottomBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Screen.Splash.route,
                modifier = Modifier) {
                composable(route = Screen.Splash.route){
                    SplashScreen(navController)
                }
                composable(route = Screen.Onboarding.route){
                    OnboardingScreen(navController)
                }
                composable(Screen.Login.route){
                    LoginScreen(navController)
                }
                composable(Screen.SignIn.route){
                    LoginScreen(navController)
                }
                composable(Screen.SignUp.route){
                    signUpScreen(navController)
                }
                composable(Screen.Agreement.route){
                    AgreementScreen()
                }
                composable(route = Screen.Beranda.route) {
                    BerandaScreen(
                        onNavigateToFieldSearch = { navController.navigate(Screen.FieldSearch.route) },
                        onNavigateToDetailField = { navController.navigate(Screen.Detail.route) },
                        onNavigateToProfile = { navController.navigate(Screen.ProfileScreen.route) }
                    )
                }
                composable(route = Screen.FieldSearch.route) {
                    FieldSearchScreen(onNavigateToBerandaScreen = { navController.navigate(Screen.Beranda.route) })
                }
                composable(route = Screen.Detail.route) {
                    DetailScreen(onNavigateToBerandaScreen = { navController.navigate(Screen.Beranda.route) })
                }
                composable(route = Screen.Category.route) {
                    CategoryFieldsScreen()
                }
                composable(route = Screen.Pemesanan.route) {
                    BookingScreen()
                }
                composable(route = Screen.Komunitas.route) {
                    BerandaScreen(
                        onNavigateToFieldSearch = { navController.navigate(Screen.FieldSearch.route) },
                        onNavigateToDetailField = { navController.navigate(Screen.Detail.route) },
                        onNavigateToProfile = { navController.navigate(Screen.ProfileScreen.route) },
                    )
                }
                composable(
                    Screen.NewsDetail.route + "/{berita}",
                    arguments = listOf(navArgument("berita") {type = NavType.IntType})
                ){navBackStackEntry ->
                    newsDetailScreen(
                        navController = navController,
                        berita = navBackStackEntry.arguments?.getInt("berita")
                    )
                }
                composable(Screen.NewsScreen.route){
                    newsScreen(navController)
                }
                composable(Screen.NewsScreen.route){
                    newsScreen(navController)
                }
                composable(Screen.ProfileScreen.route){
                    ProfileScreen(
                        onNavigateToBerandaScreen = { navController.navigate(Screen.Beranda.route) }
                    )
                }
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
