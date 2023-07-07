package com.example.cinematickets.screens.booking.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.R
import com.example.cinematickets.composable.ImageButton
import com.example.cinematickets.screens.booking.BookingUIState

import com.example.cinematickets.ui.theme.Orange80

@Composable
fun BookingScreenHeader(state: BookingUIState, modifier: Modifier = Modifier, closeButton: () -> Unit) {
    Box(modifier = modifier.aspectRatio(4f / 5f)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = state.image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop
        )

        Toolbar {
            closeButton()
        }

        ImageButton(
            painter = R.drawable.play,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center),
            backgroundColor = Orange80
        ) {}
    }
}


@Composable
private fun Toolbar(closeButton: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageButton(painter = R.drawable.close_circle) { closeButton() }
        ImageButton(painter = R.drawable.clock, text = "2h 23m") {}
    }
}