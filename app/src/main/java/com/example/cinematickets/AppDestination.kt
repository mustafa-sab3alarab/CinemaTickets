package com.example.cinematickets

sealed class AppDestination(val route : String) {
    object HomeScreen : AppDestination("homeScreen")
    object BookingScreen : AppDestination("bookingScreen")
    object TicketScreen : AppDestination("ticketScreen")
}