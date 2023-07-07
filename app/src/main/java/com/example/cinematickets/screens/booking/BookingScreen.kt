package com.example.cinematickets.screens.booking

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cinematickets.AppDestination
import com.example.cinematickets.composable.BottomSheet
import com.example.cinematickets.screens.booking.composable.BookingBottomSheetContent
import com.example.cinematickets.screens.booking.composable.BookingScreenHeader

@Composable
fun BookingScreen(
    navController: NavHostController,
    viewModel: BookingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    BookingContent(state) {
        navController.popBackStack(AppDestination.HomeScreen.route, false)
    }
}

@Composable
private fun BookingContent(state: BookingUIState, closeButton: () -> Unit) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (header, bottomSheet) = createRefs()

        val guideLine = createGuidelineFromTop(0.5f)
        BookingScreenHeader(state = state, modifier = Modifier.constrainAs(header) { top.linkTo(parent.top) }) {
            closeButton()
        }
        BottomSheet(modifier = Modifier.constrainAs(bottomSheet) { top.linkTo(guideLine) }) {
            BookingBottomSheetContent()
        }
    }
}