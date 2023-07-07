package com.example.cinematickets.screens.ticket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematickets.R
import com.example.cinematickets.composable.ImageButton
import com.example.cinematickets.ui.theme.Gray
import com.example.cinematickets.ui.theme.Orange80

@Composable
fun TicketBottomSheetContent() {

    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(top = 32.dp, end = 16.dp, start = 16.dp, bottom = 16.dp)
    ) {
        items((14..31).toList()) { item ->
            DateItem(date = item.toString(), day = "Thu", isSelected = selectedDate == item.toString()
            ) { date ->
                selectedDate = if (selectedDate == date) "" else date
            }
        }
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(listOf("10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30")) { item ->
            TimeItem(time = item, isSelected = selectedTime == item) { date ->
                selectedTime = if (selectedTime == date) "" else date
            }
        }
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "$100", color = Color.Black, fontSize = 28.sp)
            Text(text = "4 Tickets", color = Gray, fontSize = 12.sp)
        }
        ImageButton(
            painter = R.drawable.bitcoin_card,
            backgroundColor = Orange80,
            text = "Buy tickets"
        ) {}
    }
}


@Composable
private fun DateItem(
    date: String = "",
    day: String = "",
    isSelected: Boolean,
    onItemSelectedListener: (date: String) -> Unit
) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onItemSelectedListener(date) }
            .background(if (isSelected) Gray else Color.Transparent)
            .border(0.1.dp, Gray, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = date,
            fontSize = 20.sp,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier.padding(top = 8.dp, end = 16.dp, start = 16.dp)
        )
        Text(
            text = day,
            color = if (isSelected) Color.White else Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}


@Composable
fun TimeItem(
    time: String = "",
    isSelected: Boolean,
    onTimeSelectedListener: (time: String) -> Unit
) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { onTimeSelectedListener(time) }
            .background(if (isSelected) Gray else Color.Transparent)
            .border(0.1.dp, Gray, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = time,
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp),
            color = if (isSelected) Color.White else Gray
        )
    }
}