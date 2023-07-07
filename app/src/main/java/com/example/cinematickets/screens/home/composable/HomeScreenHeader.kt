package com.example.cinematickets.screens.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cinematickets.composable.OutlineButton
import com.example.cinematickets.ui.theme.Orange80

@Composable
fun HomeScreenHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlineButton(
            modifier = Modifier.padding(end = 8.dp),
            text = "Now Showing",
            textColor = Color.White,
            buttonColor = Orange80
        ) {}
        OutlineButton(text = "Coming Soon", textColor = Color.White) {}
    }
}