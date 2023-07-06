package com.example.cinematickets.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cinematickets.R
import com.example.cinematickets.ui.theme.Orange80

@Composable
fun BottomNavBar(navController: NavHostController) {
    val selectedScreen = remember { mutableStateOf("homeScreen") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White)
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ImageButton(
            painter = R.drawable.video_play,
            modifier = Modifier.size(48.dp),
            iconTint = if (selectedScreen.value == "homeScreen") Color.White else Color.Gray,
            backgroundColor = if (selectedScreen.value == "homeScreen") Orange80 else Color.Transparent
        ) {
            navController.navigate("homeScreen") {
                selectedScreen.value = "homeScreen"
            }
        }
        ImageButton(
            painter = R.drawable.search_normal,
            modifier = Modifier.size(48.dp),
            iconTint = Color.Gray,
            backgroundColor = Color.Transparent
        ) {}
        ImageButton(
            painter = R.drawable.ticket,
            modifier = Modifier.size(48.dp),
            iconTint = if (selectedScreen.value == "ticketScreen") Color.White else Color.Gray,
            backgroundColor = if (selectedScreen.value == "ticketScreen") Orange80 else Color.Transparent
        ) {
            navController.navigate("ticketScreen") {
                selectedScreen.value = "ticketScreen"
            }
        }
        ImageButton(
            painter = R.drawable.profile,
            modifier = Modifier.size(48.dp),
            iconTint = Color.Gray,
            backgroundColor = Color.Transparent
        ) {}
    }
}