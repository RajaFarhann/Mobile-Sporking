package com.example.sporkingapp.presentation.screen.whatsapp

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@Composable
fun WhatsAppRedirect(
    phoneNumber: String,
    message: String
) {
    val context = LocalContext.current

    Button(
        onClick = {
            val url = "https://wa.me/$phoneNumber?text=${Uri.encode(message)}"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            context.startActivity(intent)
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Chat on WhatsApp")
    }
}


@Preview
@Composable
fun WhatsAppRedirectPreview() {
    SporkingAppTheme {
        WhatsAppRedirect(phoneNumber = "+6281371944544", message = "Hello, I need some help!")
    }
}