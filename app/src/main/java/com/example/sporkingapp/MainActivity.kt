package com.example.sporkingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sporkingapp.presentation.MainScreen
import com.example.sporkingapp.ui.theme.SporkingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SporkingAppTheme {
                MainScreen()
            }
        }
    }
}
