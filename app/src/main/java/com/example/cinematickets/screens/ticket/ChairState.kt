package com.example.cinematickets.screens.ticket

import androidx.compose.ui.graphics.Color
import com.example.cinematickets.ui.theme.Gray
import com.example.cinematickets.ui.theme.Orange80

sealed class ChairState(val chairColor: Color) {
    object Available : ChairState(Color.White)
    object Taken : ChairState(Gray)
    object Selected : ChairState(Orange80)

    fun nextState(): ChairState {
        return when (this) {
            Available -> Selected
            Taken -> Taken
            Selected -> Available
        }
    }
}