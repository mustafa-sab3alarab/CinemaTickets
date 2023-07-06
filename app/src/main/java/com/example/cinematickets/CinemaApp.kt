package com.example.cinematickets

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavBar(navController) }) {
            NavHost(navController = navController, startDestination = "HomeScreen") {
                composable("homeScreen") { HomeScreen(navController) }
                composable(
                    "bookingScreen/{id}",
                    arguments = listOf(
                        navArgument("id") { NavType.IntType }
                    )
                ) { BookingScreen(navController) }
                composable("ticketScreen") { TicketScreen(navController) }
            }
        }
    }

}

@Composable
private fun BottomNavBar(navController: NavHostController) {
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