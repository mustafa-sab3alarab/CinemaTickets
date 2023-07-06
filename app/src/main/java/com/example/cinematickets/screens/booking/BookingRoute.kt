package com.example.cinematickets.screens.booking

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cinematickets.AppDestination

private val ROUTE = AppDestination.BookingScreen.route

fun NavController.navigateToBookingScreen(imageId: Int) {
    navigate("$ROUTE/$imageId")
}

fun NavGraphBuilder.bookingRoute(navHostController: NavHostController) {
    composable(
        "$ROUTE/{${BookingArgs.ARG_IMAGE_ID}}",
        arguments = listOf(
            navArgument(BookingArgs.ARG_IMAGE_ID) { NavType.IntType }
        )
    ) { BookingScreen(navHostController) }
}

class BookingArgs(savedStateHandle: SavedStateHandle) {
    val imageId = checkNotNull(savedStateHandle[ARG_IMAGE_ID])

    companion object {
        const val ARG_IMAGE_ID = "imageId"
    }
}