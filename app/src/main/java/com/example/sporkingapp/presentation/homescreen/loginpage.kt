
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.R
import com.example.sporkingapp.presentation.component.BottomBar
import com.example.sporkingapp.presentation.component.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
) {
    // State untuk menyimpan nilai teks
    var textState by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Batam") }

    val options = listOf("Batam", "Jakarta", "Bandung")

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFFD7900)) // Warna oranye
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 120.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
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
                                textAlign = TextAlign.Center
                            )
                        },
                        textStyle = TextStyle(fontSize = 12.sp),
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
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = selectedOption,
                                color = Color.Black,
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
                            modifier = Modifier.background(Color.White)
                        ) {
                            options.forEach { option ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedOption = option
                                        expanded = false
                                    },
                                    text = { Text(option) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonWithDynamicWidth(text: String, onClick: () -> Unit) {
    var textWidth by remember { mutableStateOf(0) }

    // Mengukur lebar teks
    Text(
        text = text,
        modifier = Modifier.onGloballyPositioned {
            textWidth = it.size.width
        }
    )

    // Mengubah lebar tombol sesuai dengan lebar teks
    Button(
        onClick = onClick,
        modifier = Modifier.width(with(LocalDensity.current) { textWidth.toDp() })
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun Example() {
    Column {
        ButtonWithDynamicWidth(text = "Short", onClick = {})
        ButtonWithDynamicWidth(text = "Longer Text", onClick = {})
        ButtonWithDynamicWidth(text = "A Very Long Text Inside Button", onClick = {})
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewLoginPage() {
//    SporkingAppTheme {
//        LoginPage()
//    }
//}
