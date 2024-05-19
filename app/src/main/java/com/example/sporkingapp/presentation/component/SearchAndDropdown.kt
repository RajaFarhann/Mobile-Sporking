package com.example.sporkingapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.ui.theme.SporkingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAndDropdown(
    modifier: Modifier = Modifier
) {
    // State untuk menyimpan nilai teks
    var textState by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Batam") }

    val options = listOf("Batam", "Jakarta", "Bandung")

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = Modifier
                .size(width = 220.dp, height = 45.dp),
            placeholder = {
                Text(
                    text = "Cari Lapangan Di $selectedOption",
                    style = TextStyle(fontSize = 12.sp),
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFD7900)
                )
            },
            textStyle = TextStyle(fontSize = 12.sp, color = Color(0xFFFD7900)),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.icon_search_orange),
                    contentDescription = "Search Icon",
                    tint = Color.Unspecified // Mengatur warna ikon ke tidak ditentukan untuk mempertahankan warna aslinya
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                disabledBorderColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp), // Menambahkan bentuk rounded
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(onSearch = { /* Handle Search action */ })
        )
        Box(
            modifier = Modifier
                .size(width = 120.dp, height = 45.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .clickable { expanded = true },
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Text(
                    text = selectedOption,
                    color = Color(0xFFFD7900),
                    style = TextStyle(fontSize = 12.sp)
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_dropdown_orange),
                    contentDescription = "Dropdown Icon"
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(Color.White)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption = option
                            expanded = false
                        },
                        text = {
                            Text(
                                text = option,
                                color = if (option == selectedOption) Color(0xFFFD7900) else Color.Black
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchAndDropdown () {
    SporkingAppTheme{
        SearchAndDropdown()
    }
}