package com.example.sporkingapp.presentation.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.R
import com.example.sporkingapp.presentation.component.ImagePickerGallery
import com.example.sporkingapp.presentation.component.bar.TopBar
import com.example.sporkingapp.presentation.component.button.TransparentButtonComponent

@Composable
fun ProfileScreen(onNavigateToBerandaScreen: () -> Unit,){
Scaffold (
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
    ){innerPadding ->
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(24.dp)
                .padding(innerPadding)
        ){
            Column (
                modifier = Modifier.fillMaxSize()
            ){
                ImagePickerGallery()
                Spacer(modifier = Modifier.height(12.dp))

                TransparentButtonComponent(value = stringResource(id = R.string.akun), image = painterResource(
                    id = R.drawable.icon_lock), onTaskClick = { }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TransparentButtonComponent(value = stringResource(id = R.string.beri_rating), image = painterResource(
                    id = R.drawable.icon_star), onTaskClick = {null})
            }
        }
    }
}