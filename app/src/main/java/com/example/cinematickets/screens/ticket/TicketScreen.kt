package com.example.cinematickets.screens.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.composable.BottomSheet
import com.example.cinematickets.screens.ticket.composable.CinemaChairs
import com.example.cinematickets.screens.ticket.composable.CircleWithText
import com.example.cinematickets.screens.ticket.composable.TicketBottomSheetContent
import com.example.cinematickets.screens.ticket.composable.TicketScreenHeader
import com.example.cinematickets.ui.theme.BlackBackground
import com.example.cinematickets.ui.theme.Gray
import com.example.cinematickets.ui.theme.Orange80

@Composable
fun TicketScreen(
    modifier: Modifier = Modifier,
) {
    TicketContent(modifier)
}


@Composable
fun TicketContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BlackBackground)
    ) {

        TicketScreenHeader(painterId = R.drawable.image_ticket_header)

        CinemaChairs()

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CircleWithText(text = "Available", circleTint = Color.White)
            CircleWithText(text = "Taken", circleTint = Gray)
            CircleWithText(text = "Selected", circleTint = Orange80)
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomSheet {
            TicketBottomSheetContent()
        }
    }
}
