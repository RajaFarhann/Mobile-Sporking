package com.example.sporkingapp.presentation.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sporkingapp.R
import com.example.sporkingapp.data.local.datastore.DataStore
import com.example.sporkingapp.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    val context = LocalContext.current
    val scale = remember { Animatable(0f) }
    val dataStore = DataStore(context)

    val statusLoggedIn = dataStore.getStatusLogin.collectAsState(initial = false)

    LaunchedEffect(
        key1 = true,
        block = {
            scale.animateTo(
                targetValue = 0.9f,
                animationSpec = tween(
                    durationMillis = 900
                )
            )
            delay(2000L)
            if (statusLoggedIn.value) {
                navController.navigate(Screen.Beranda.route){
                    popUpTo(Screen.Splash.route){
                        inclusive = true
                    }
                }
            } else {
                navController.navigate(Screen.Onboarding.route) {
                    popUpTo(Screen.Splash.route) {
                        inclusive = true
                    }
                }
            }
        }
    )

    Surface (
        modifier = Modifier
            .padding(16.dp)
            .scale(scale.value)
            .fillMaxSize()
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(painter = painterResource(id = R.drawable.sprorkinglogoandtext), contentDescription = null)
        }
    }
}