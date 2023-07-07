package com.example.cinematickets.screens.booking.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composable.CircleAvatar
import com.example.cinematickets.composable.ImageButton
import com.example.cinematickets.composable.OutlineButton
import com.example.cinematickets.ui.theme.Orange80
import com.example.cinematickets.ui.theme.Typography
import com.example.cinematickets.util.Constant

@Composable
fun BookingBottomSheetContent() {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    MovieTextDetails(title = "6.8/10", subtitle = "IMDb")
                    MovieTextDetails(title = "63%", subtitle = "Rotten Tomatoes")
                    MovieTextDetails(title = "4/10", subtitle = "IGN")
                }

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Fantastic Beasts: The\nSecrets of Dumbledore",
                    textAlign = TextAlign.Center,
                    style = Typography.titleLarge
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlineButton(text = "Fantasy") {}
            OutlineButton(modifier = Modifier.padding(start = 8.dp), text = "Adventure") {}
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(20) { CircleAvatar(imageUrl = Constant.DEFAULT_IMAGE) }
        }

        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.booking_screen_content),
                style = Typography.labelSmall
            )

            Spacer(modifier = Modifier.weight(1f))

            ImageButton(
                painter = R.drawable.bitcoin_card,
                backgroundColor = Orange80,
                text = "Booking",
                textSize = 16
            ) {

            }
        }
    }
}