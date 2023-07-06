package com.example.cinematickets.screens.ticket

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cinematickets.AppDestination

fun NavGraphBuilder.ticketRoute(navHostController: NavHostController) {
    composable(AppDestination.TicketScreen.route) { TicketScreen(navHostController) }
}