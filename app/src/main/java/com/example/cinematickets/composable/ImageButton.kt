package com.example.cinematickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.LightWhite
import com.example.cinematickets.ui.theme.TextWhite

@Composable
fun ImageButton(
    painter: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = LightWhite,
    iconTint : Color = Color.White,
    text: String = "",
    textSize : Int = 16,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(color = backgroundColor)
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(painter),
            contentDescription = "$text button",
            tint = iconTint
        )
        if (text.isNotEmpty()) {
            SpacerHorizontal8()
            Text(
                text = text,
                fontSize = textSize.sp,
                color = TextWhite
            )
        }
    }
}