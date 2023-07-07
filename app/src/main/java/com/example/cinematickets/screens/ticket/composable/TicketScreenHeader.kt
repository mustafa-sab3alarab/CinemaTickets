package com.example.cinematickets.screens.ticket.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TicketScreenHeader(
    modifier: Modifier = Modifier,
    painterId : Int
) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 64.dp, bottom = 16.dp)
            .fillMaxHeight(0.15f),
        painter = painterResource(id = painterId),
        contentDescription = "Header Image",
    )
}