package com.example.spork.presentation.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sporkingapp.R
import com.example.sporkingapp.presentation.component.text.BoldTextComponent
import com.example.sporkingapp.presentation.component.text.NormalTextComponentJustify
import com.example.sporkingapp.presentation.component.Switches


@Composable
fun notifySecurityScreen(navController: NavController){

    Scaffold (
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
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(120.dp),
                    painter = painterResource(id = R.drawable.icon_lock150),
                    contentDescription = "lock icon")
                Spacer(modifier = Modifier.height(12.dp))
                BoldTextComponent(value = stringResource(id = R.string.chat_and_login))

                Spacer(modifier = Modifier.height(8.dp))
                NormalTextComponentJustify(value = stringResource(id = R.string.dapatkan_notifikasi))

                Spacer(modifier = Modifier.height(12.dp))

                Switches(value = stringResource(id = R.string.tampilkan_notifikasi))

            }
        }
    }
}