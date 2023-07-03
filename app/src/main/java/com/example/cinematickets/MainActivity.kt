package com.example.cinematickets

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cinematickets.screens.BookingScreen
import com.example.cinematickets.screens.HomeScreen
import com.example.cinematickets.ui.theme.CinemaTicketsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            CinemaTicketsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HomeScreen()
                }
            }
        }
    }
}