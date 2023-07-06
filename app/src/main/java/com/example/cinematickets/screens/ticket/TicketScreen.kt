package com.example.cinematickets.screens.ticket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.cinematickets.R
import com.example.cinematickets.composable.Circle
import com.example.cinematickets.composable.ImageButton
import com.example.cinematickets.ui.theme.BlackBackground
import com.example.cinematickets.ui.theme.Gray
import com.example.cinematickets.ui.theme.Orange80

@Composable
fun TicketScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
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

        Header()
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

        BottomSheet()
    }


}

@Composable
fun BottomSheet() {

    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Color.White)
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(top = 32.dp, end = 16.dp, start = 16.dp, bottom = 16.dp)
        ) {
            items((14..31).toList()) { item ->
                DateItem(date = item.toString(), isSelected = selectedDate == item.toString()) { date ->
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

        Spacer(modifier = Modifier.weight(1f))
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
}

@Composable
fun DateItem(
    date: String,
    day: String = "Thu",
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

@Composable
fun CircleWithText(
    text: String = "",
    circleTint: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Circle(tint = circleTint, modifier = Modifier.padding(end = 12.dp))
        Text(text = text, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
private fun Header() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp, bottom = 16.dp)
            .fillMaxHeight(0.15f),
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Header Image",
    )
}

@Composable
private fun CinemaChairs() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(count = 3)
    ) {
        itemsIndexed(
            listOf(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
            )
        ) { index: Int, item: String ->
            when (index % 3) {
                0 -> ChairItem(10f)
                1 -> ChairItem(0f, offset = 9f)
                2 -> ChairItem(-10f)
            }
        }
    }
}

@Composable
private fun ChairItem(
    rotate: Float,
    offset: Float = 0f
) {
    ConstraintLayout(
        modifier = Modifier
            .rotate(rotate)
            .offset(y = offset.dp)
            .size(45.dp)
    ) {
        val (chair1, chair2, container) = createRefs()
        Icon(
            modifier = Modifier
                .size(75.dp)
                .constrainAs(chair1) {
                    bottom.linkTo(container.bottom, margin = 4.dp)
                },
            painter = painterResource(id = R.drawable.chair),
            contentDescription = "",
            tint = Orange80
        )
        Icon(
            modifier = Modifier
                .size(75.dp)
                .constrainAs(chair2) {
                    bottom.linkTo(container.bottom, margin = 4.dp)
                    end.linkTo(container.end)
                },
            painter = painterResource(id = R.drawable.chair),
            contentDescription = "",
            tint = Color.White
        )

        Icon(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(container) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.chair_container),
            contentDescription = "",
            tint = Gray
        )
    }
}
