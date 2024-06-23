package com.example.sporkingapp.presentation.screen.profile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sporkingapp.R
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.ImagePickerGallery
import com.example.sporkingapp.presentation.component.bar.TopBar
import com.example.sporkingapp.presentation.component.button.TransparentButtonComponent
import com.example.sporkingapp.presentation.screen.profile.component.ExitHeader
import com.example.sporkingapp.utils.Constant.CLIENT
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(
    navController: NavController,
    context: Context = LocalContext.current
){

    var isSignedOut by remember { mutableStateOf(false) }

    if (isSignedOut){
        LaunchedEffect(Unit) {
            navController.navigate(Screen.Login.route){
                popUpTo(Screen.Onboarding.route){
                    inclusive = true
                }
            }
        }
    } else {
        ProfileContent(
            navController = navController,
            onLogoutClick = {
                val googleLogin =
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .requestIdToken(CLIENT)
                        .build()

                @Suppress("DEPRECATION")
                val googleClient = GoogleSignIn.getClient(context, googleLogin)
                googleClient.signOut().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        FirebaseAuth.getInstance().signOut()
                        isSignedOut = true
                    } else {
                        Toast.makeText(
                            context,
                            "Logout Gagal",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        ){

        }
    }
}

@Composable
fun ProfileContent(
    navController: NavController,
    onLogoutClick: () -> Unit,
    onNavigateToBerandaScreen: () -> Unit,
){
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
        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(innerPadding)
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ){
                ExitHeader(
                    onLogoutClick = onLogoutClick,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
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