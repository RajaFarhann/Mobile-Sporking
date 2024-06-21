package com.example.sporkingapp.presentation.screen.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.sporkingapp.presentation.component.button.GoogleButtonComponent
import com.example.sporkingapp.presentation.component.clickable.ClickableTextBelumPunyaAkunComponent
import com.example.sporkingapp.presentation.component.text.BoldTextComponent
import com.example.sporkingapp.presentation.component.text.NormalTextComponent
import com.example.sporkingapp.presentation.component.textfield.MyOutlinedTextField
import com.example.sporkingapp.presentation.component.textfield.PasswordTextField

@Composable
fun signInScreen(navController: NavController){

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(24.dp)
    ){
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            Image(painter = painterResource(id = R.drawable.sprorkinglogoandtext),
                contentDescription = "Sporking",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))

            BoldTextComponent(value = stringResource(id = R.string.welcome))
            NormalTextComponent(value = stringResource(id = R.string.temukan_lapangan))

            Spacer(modifier = Modifier.height(50.dp))

            MyOutlinedTextField(labelValue = stringResource(id = R.string.email), value = stringResource(id = R.string.email), painterResource(id = R.drawable.mail)
            )

            Spacer(modifier = Modifier.height(16.dp))

            PasswordTextField(labelValue = stringResource(id = R.string.password), value = stringResource(
                id = R.string.password), painterResource = painterResource(id = R.drawable.lock)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Spacer(modifier = Modifier.height(12.dp))
            ClickableTextBelumPunyaAkunComponent(onTextSelected = {navController.navigate(Screen.SignUp.route)})

            Spacer(modifier = Modifier.height(30.dp))
            ButtonComponent(value = stringResource(id = R.string.masuk), onTaskClick = {null})

            Spacer(modifier = Modifier.height(15.dp))
            NormalTextComponent(value = stringResource(id = R.string.atau))
            Spacer(modifier = Modifier.height(15.dp))

            //this button for sigin up with Google
            GoogleButtonComponent(value = stringResource(id = R.string.daftar_dengan_google),
                image = painterResource(id = R.drawable.google_icon), onTaskClick = {null}
            )

        }
    }

}

@Preview
@Composable
fun signInScreenPreview(){
    signInScreen(navController = rememberNavController())
}
