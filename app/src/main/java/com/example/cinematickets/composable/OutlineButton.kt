package com.example.cinematickets.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.Gray
import com.example.cinematickets.ui.theme.Orange80
import com.example.cinematickets.ui.theme.TextWhite

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textSize: Int = 14,
    buttonColor : Color = Color.Transparent,
    textColor : Color = Color.Black,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        border = BorderStroke(0.5.dp, Gray),
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        Text(
            text = text,
            fontSize = textSize.sp,
            color = textColor
        )
    }
}