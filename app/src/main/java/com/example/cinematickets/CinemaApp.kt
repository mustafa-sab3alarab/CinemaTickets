package com.example.cinematickets

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinematickets.composable.ImageButton
import com.example.cinematickets.screens.booking.BookingScreen
import com.example.cinematickets.screens.home.HomeScreen
import com.example.cinematickets.screens.ticket.TicketScreen
import com.example.cinematickets.ui.theme.CinemaTicketsTheme
import com.example.cinematickets.ui.theme.Orange80

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaApp() {
    CinemaTicketsTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavBar() }) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "HomeScreen") {
                composable("homeScreen") { HomeScreen() }
                composable("bookingScreen") { BookingScreen() }
                composable("ticketScreen") { TicketScreen() }
            }
        }
    }

}

@Composable
private fun BottomNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ImageButton(
            painter = R.drawable.video_play,
            modifier = Modifier.size(48.dp),
            backgroundColor = Orange80
        ) {}
        ImageButton(
            painter = R.drawable.search_normal,
            modifier = Modifier.size(48.dp),
            iconTint = Color.Gray,
            backgroundColor = Color.Transparent
        ) {}
        ImageButton(
            painter = R.drawable.ticket,
            modifier = Modifier.size(48.dp),
            iconTint = Color.Gray,
            backgroundColor = Color.Transparent
        ) {}
        ImageButton(
            painter = R.drawable.profile,
            modifier = Modifier.size(48.dp),
            iconTint = Color.Gray,
            backgroundColor = Color.Transparent
        ) {}
    }
}