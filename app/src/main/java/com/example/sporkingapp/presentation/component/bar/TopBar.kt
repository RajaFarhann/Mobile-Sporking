package com.example.sporkingapp.presentation.component.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    showTitle: Boolean = true,
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    showProfileImage: Boolean = true,
    profileImageResId: Int = R.drawable.icon_profile,
    showChatIcon: Boolean = true,
    showNotificationIcon: Boolean = true
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (showBackButton) {
                    IconButton(onClick = onBackClick) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_arrow_back),
                            contentDescription = "Back",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                if (showProfileImage) {
                    IconButton(onClick =  onProfileClick ) {
                        Image(
                            painter = painterResource(id = profileImageResId),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(40.dp)
                                .padding(end = 8.dp)
                        )
                    }
                }
                if (showTitle) {
                    Text(
                        text = "Halo",
                        color = Color.White,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = if (showBackButton) 8.dp else 0.dp)
                    )
                }
            }
        },
        actions = {
            if (showChatIcon) {
                IconButton(onClick = { /* TODO: Handle chat icon click */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_chat),
                        contentDescription = "Chat",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
            if (showNotificationIcon) {
                IconButton(onClick = { /* TODO: Handle notification icon click */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_notification),
                        contentDescription = "Notification",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFD7900))
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    SporkingAppTheme {
        TopBar(
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarWithBackButtonPreview() {
    SporkingAppTheme {
        TopBar(
            showTitle = false,
            showBackButton = true,
            onBackClick = { /* TODO: Handle back button click */ },
            showProfileImage = false,
            showChatIcon = false,
            showNotificationIcon = false
        )
    }
}
