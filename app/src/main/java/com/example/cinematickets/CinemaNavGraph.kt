package com.example.cinematickets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.cinematickets.screens.booking.bookingRoute
import com.example.cinematickets.screens.home.homeRoute
import com.example.cinematickets.screens.ticket.ticketRoute

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = AppDestination.HomeScreen.route
    ) {

        homeRoute(navHostController)

        bookingRoute(navHostController)

        ticketRoute(navHostController)
    }
}