package com.example.cinematickets.screens.ticket.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematickets.R
import com.example.cinematickets.screens.ticket.ChairState
import com.example.cinematickets.ui.theme.Gray


@Composable
fun CinemaChairs() {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(count = 3)
    ) {
        items(15) {
            when (it % 3) {
                0 -> ChairItem(rotate = 10f)
                1 -> ChairItem(rotate = 0f, offset = 9f)
                2 -> ChairItem(rotate = -10f)
            }
        }
    }
}

@Composable
private fun ChairItem(
    modifier: Modifier = Modifier,
    offset: Float = 0f,
    rotate: Float,
    chairState: Pair<ChairState, ChairState> = Pair(ChairState.Available, ChairState.Available)
) {

    var leftChairState by remember { mutableStateOf(chairState.first) }
    var rightChairState by remember { mutableStateOf(chairState.second) }

    val leftChairColor by animateColorAsState(getChairColor(leftChairState))
    val rightChairColor by animateColorAsState(getChairColor(rightChairState))

    Box(
        modifier = modifier
            .rotate(rotate)
            .offset(y = offset.dp)
            .size(45.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.chair_container),
            contentDescription = "chair container",
            tint = Gray
        )

        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(75.dp)
                    .weight(1f)
                    .clickable { leftChairState = leftChairState.nextState() },
                painter = painterResource(id = R.drawable.chair),
                contentDescription = "left chair",
                tint = leftChairColor
            )
            Icon(
                modifier = Modifier
                    .size(75.dp)
                    .padding(end = 16.dp)
                    .weight(1f)
                    .clickable { rightChairState = rightChairState.nextState() },
                painter = painterResource(id = R.drawable.chair),
                contentDescription = "right chair",
                tint = rightChairColor
            )
        }

    }
}

private fun getChairColor(chair: ChairState): Color {
    return when (chair) {
        ChairState.Available -> ChairState.Available.chairColor
        ChairState.Taken -> ChairState.Taken.chairColor
        ChairState.Selected -> ChairState.Selected.chairColor
    }
}