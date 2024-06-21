package com.example.sporkingapp.presentation.screen.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.mainOrange
import com.example.sporkingapp.ui.theme.primary

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
){
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = mainOrange,
            focusedLabelColor = mainOrange,
            cursorColor = primary,
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.mail),
                contentDescription = "Email icon"
            )
        },
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
        value = value,
        onValueChange = onValueChange,

        )
}