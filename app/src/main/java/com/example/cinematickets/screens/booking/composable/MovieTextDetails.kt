package com.example.cinematickets.screens.booking.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.cinematickets.ui.theme.Gray
import com.example.cinematickets.ui.theme.Typography

@Composable
fun MovieTextDetails(
    title: String = "",
    subtitle: String = "",
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = Typography.bodyLarge
        )
        Text(
            text = subtitle,
            style = Typography.labelSmall
        )
    }
}