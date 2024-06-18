package com.example.sporkingapp.presentation.component.clickable

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.sporkingapp.ui.theme.clickableBlueish

@Composable
fun ClickableTextBelumPunyaAkunComponent(onTextSelected: (String) -> Unit){
    val initialText = "Belum Punya Akun? "
    val daftarText = "Daftar"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = clickableBlueish)){
            pushStringAnnotation(tag = daftarText, annotation = daftarText)
            append(daftarText)
        }
    }


    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = {offset ->
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also { span->
                    Log.d("ClickableTextComponent", "{$span}")

                    if((span.item == daftarText)) {
                        onTextSelected(span.item)
                    }
                }
        }
    )
}