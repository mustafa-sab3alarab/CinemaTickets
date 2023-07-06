package com.example.cinematickets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cinematickets.composable.BottomNavBar
import com.example.cinematickets.ui.theme.CinemaTicketsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaApp() {
    CinemaTicketsTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavBar(navController) }) {
            NavGraph(navHostController = navController, modifier = Modifier.padding(it))
        }
    }
}

