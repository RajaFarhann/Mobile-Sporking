package com.example.sporkingapp.presentation.screen.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.mainOrange
import com.example.sporkingapp.ui.theme.secondButton

@Composable
fun GoogleButton(
    clicked: () -> Unit,
    isConnectLoading: Boolean = false,
    modifier: Modifier = Modifier
){
    Button(
        onClick = clicked,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = RoundedCornerShape(7.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(secondButton)
    ) {
        if (isConnectLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(32.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "Google Icon"
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Daftar Dengan Google",
                color = mainOrange,
            )
        }
    }
}
