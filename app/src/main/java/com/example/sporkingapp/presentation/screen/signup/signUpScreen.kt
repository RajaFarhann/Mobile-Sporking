package com.example.sporkingapp.presentation.screen.signup

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sporkingapp.R
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.component.button.ButtonComponent
import com.example.sporkingapp.presentation.component.checkbox.CheckBoxComponent
import com.example.sporkingapp.presentation.component.clickable.ClickableTextSudahPunyaAkunComponent
import com.example.sporkingapp.presentation.component.text.BoldTextOrangeComponent
import com.example.sporkingapp.presentation.component.textfield.MyOutlinedTextField
import com.example.sporkingapp.presentation.component.textfield.PasswordTextField

@Composable
fun signUpScreen(navController: NavController){
    Scaffold {innerPadding ->
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
                BoldTextOrangeComponent(value = stringResource(id = R.string.daftar_akun))

                Spacer(modifier = Modifier.height(42.dp))
                MyOutlinedTextField(labelValue = stringResource(id = R.string.nama_depan), value = stringResource(
                    id = R.string.nama_depan), painterResource = painterResource(id = R.drawable.person_x64)
                )
                Spacer(modifier = Modifier.height(16.dp))
                MyOutlinedTextField(labelValue = stringResource(id = R.string.nama_belakang), value = stringResource(
                    id = R.string.nama_belakang), painterResource = painterResource(id = R.drawable.person_x64)
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField(labelValue = stringResource(id = R.string.password), value = stringResource(
                    id = R.string.password), painterResource = painterResource(id = R.drawable.lock)
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField(labelValue = stringResource(id = R.string.repeat_password), value = stringResource(
                    id = R.string.repeat_password), painterResource = painterResource(id = R.drawable.lock)
                )
                CheckBoxComponent(value = stringResource(id = R.string.term_of_use),
                    onTextSelected = {navController.navigate(Screen.Agreement.route)}
                )

                Spacer(modifier = Modifier.height(24.dp))
                ClickableTextSudahPunyaAkunComponent(onTextSelected = {navController.navigate(Screen.Login.route)})
                Spacer(modifier = Modifier.height(24.dp))

                ButtonComponent(value = stringResource(id = R.string.daftar_akun), onTaskClick = { navController.navigate(Screen.Login.route) })
            }
        }

    }
}

@Preview
@Composable
fun signUpScreenPreview(){
    signUpScreen(navController = rememberNavController())
}