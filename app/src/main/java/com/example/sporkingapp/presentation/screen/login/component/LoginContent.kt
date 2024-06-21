package com.example.sporkingapp.presentation.screen.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.R
import com.example.sporkingapp.presentation.component.text.BoldTextComponent
import com.example.sporkingapp.presentation.component.text.NormalTextComponent
import com.example.sporkingapp.ui.theme.mainOrange

@Composable
fun LoginContent(
    name: String,
    email: String,
    password: String,
    passwordConfirm: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleClick: () -> Unit,
    toggleAuthMode: () -> Unit,
    moveToForget: () -> Unit,
    isRegistering: Boolean,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
){
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ){
            Spacer(modifier = Modifier.height(40.dp))

            Text( //Color for masuk or datar
                text = if (isRegistering) "Daftar" else "",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Medium,
                color = mainOrange
            )
            Image(painter = painterResource(id = R.drawable.sprorkinglogoandtext),
                contentDescription = "Sporking",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))

            BoldTextComponent(value = stringResource(id = R.string.welcome))
            NormalTextComponent(value = stringResource(id = R.string.temukan_lapangan))

            Spacer(modifier = Modifier.height(50.dp))

            if (isRegistering){
                EmailTextField(
                    value = name,
                    onValueChange = onNameChange,
                    label = "Nama Lengkap",
                    contentDescription = "Nama Lengkap"
                )
            }
            EmailTextField(
                value = email,
                onValueChange = onEmailChange,
                label = "Email",
                contentDescription = "Email"
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordTextFieldLogin(
                text = password,
                onValueChange = onPasswordChange,
                label = "Password"
            )
            if (isRegistering){
                PasswordTextFieldLogin(
                    text = passwordConfirm,
                    onValueChange = onPasswordConfirmChange,
                    label = "Konfirmasi Password"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            // navigation for "daftar" will be here
            Row (
                modifier = modifier.height(40.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = if (isRegistering) "Sudah punya akun?" else "Belum punya akun")
                TextButton(onClick = toggleAuthMode) {
                    Text(
                        text = if (isRegistering) "Masuk" else "Daftar",
//                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
//            Spacer(modifier = Modifier.height(12.dp))
            TextButton(
                onClick = moveToForget,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Lupa Kata Sandi?")
            }

            Spacer(modifier = Modifier.height(30.dp))

            //This button is for Login
            Button(
                onClick = if (isRegistering) onRegisterClick else onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(52.dp),
                shape = RoundedCornerShape(7.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(mainOrange)
            ){
                Text(
                    text = if (isRegistering) "Daftar" else "Masuk",
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            NormalTextComponent(value = stringResource(id = R.string.atau))
            Spacer(modifier = Modifier.height(15.dp))

            //This button is for Register using Google Account
            GoogleButton(clicked = onGoogleClick)
        }
    }
}